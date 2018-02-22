package com.test.mwigzell.test;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by mwigzell on 11/23/16.
 */

public class Sudoku {
    static final int QUADRANT_MAX = Quadrant.QUADRANT_MAX;
    public static final int BOARD_MAX = QUADRANT_MAX * QUADRANT_MAX;
    static final int MOVES_MAX = BOARD_MAX * BOARD_MAX;
    public static final int EMPTY = Quadrant.EMPTY;

    int[][] board;
    int moves;
    int highestMove;
    int lowestUnmove;
    Random random;

    Quadrant[][] quadrants;
    int[][][] values;
    int[][] count;

    void initValues() {
        values = new int[BOARD_MAX][BOARD_MAX][9+1]; // row/col constraints
        for (int r = 0; r < BOARD_MAX; r++) {
            for (int c = 0; c < BOARD_MAX; c++) {
                Arrays.fill(values[r][c], 0);
            }
        }
    }

    void initQuadrants() {
        quadrants = new Quadrant[QUADRANT_MAX][QUADRANT_MAX];
        for (int r = 0; r < QUADRANT_MAX; r++) {
            for (int c = 0; c < QUADRANT_MAX; c++) {
                quadrants[r][c] = new Quadrant(board, r, c);
            }
        }
    }

    public Sudoku() {
        board = new int[BOARD_MAX][BOARD_MAX];
        initValues();
        initQuadrants();
        count = new int[BOARD_MAX][BOARD_MAX];
        random = new Random();
        clear();
    }

    int toQuadrant(int index) {
        int i = (index / QUADRANT_MAX);
        return i;
    }

    /**
     * Enumerate and constrain all quadrants to the board values
     */
    void constrainQuadrants() {
        for (int r = 0; r < QUADRANT_MAX; r++) {
            for (int c = 0; c < QUADRANT_MAX; c++) {
                quadrants[toQuadrant(r)][toQuadrant(c)].constrainValues();
            }
        }
    }

    public void clear() {
        for (int i = 0; i < BOARD_MAX; i++) {
            for (int j = 0; j < BOARD_MAX; j++) {
                board[i][j] = EMPTY;
            }
        }
        constrainQuadrants();
        moves = highestMove = lowestUnmove = 0;
    }

    public int moveNumber() {
        return moves;
    }

    public boolean isLegalMove(int r, int c, int value) {
        boolean rc = false;
        if ( board[r][c] == EMPTY) {
            if (values[r][c][value] > 0) {
                return false; // value is already constrained for this cell
            }
            // check quadrant for duplicate
            if (!quadrants[toQuadrant(r)][toQuadrant(c)].isLegalValue(value)) {
                return false;
            }
            rc = true;
        }
        return rc;
    }

    void count(int r, int c) {
        count[r][c] = 0;
        for (int i = 1; i < 10; i++) {
            int v = values[r][c][i];
            if (v == 0 && quadrants[toQuadrant(r)][toQuadrant(c)].isLegalValue(i)) {
                count[r][c]++;
            }
        }
    }

    /**
     * A new value is being placed on the board: reconstrain the affected row, column and quadrants
     * @param r
     * @param c
     * @param value
     */
    void addConstraint(int r, int c, int value) {
        //row and column constraints are not implemented
        quadrants[toQuadrant(r)][toQuadrant(c)].addConstraint(value);
        // constrain all cells in the current row to the value for this cell
        for (int i = 0; i < BOARD_MAX; i++) {
            values[r][i][value] += 1;
            count(r, i);
        }

        // constrain all cells in the current col to the value for this cell
        for (int i = 0; i < BOARD_MAX; i++) {
            // don't add the current column again, since it was added for the cell row above
            if (i != r) {
                values[i][c][value] += 1;
                count(i, c);
            }
        }
    }

    /**
     * A value is being removed from the board: reconstrain the affected row, column and quadrants
     * @param r
     * @param c
     * @param value
     */
    void removeConstraint(int r, int c, int value) {
        //row and column constraints are not implemented
        quadrants[toQuadrant(r)][toQuadrant(c)].removeConstraint(value);

        // unconstrain all cells in the current row for the (removed) value of this cell
        for (int i = 0; i < BOARD_MAX; i++) {
            values[r][i][value] -= 1;
            count(r, i);
        }

        // unconstrain all cells in the current col for the (removed) value of this cell
        for (int i = 0; i < BOARD_MAX; i++) {
            // don't subtract the current column again, since it was subtracted for the cell row above
            if (i != r) {
                values[i][c][value] -= 1;
                count(i, c);
            }
        }
    }

    public void move(int r, int c, int value) {
        // push move
        board[r][c] = value;
        moves++;
        addConstraint(r, c, value);

        if (moves > highestMove) {
            highestMove = moves;
            System.out.println("High water mark=" + moves + " r=" + r + " c=" + c + " value=" + value);
            printBoard();
        }
    }

    public void unmove(int r, int c) {
        if (lowestUnmove == 0 || moves < lowestUnmove) {
            lowestUnmove = moves;
            System.out.println("Unmove=" + moves + " r=" + r + " c=" + c + " value=" + board[r][c]);
        }

        // pop move
        int v = board[r][c];
        board[r][c] = EMPTY;
        removeConstraint(r, c, v);
        moves--;

    }

    public boolean isGameOver() {
        return moves == MOVES_MAX;
    }

    public void loadPuzzle(int[][] puzzle) {
        for (int r = 0; r < BOARD_MAX; r++) {
            for (int c = 0; c < BOARD_MAX; c++) {
                if (puzzle[r][c] != 0) {
                    move(r, c, puzzle[r][c]);
                }
            }
        }
    }

    /**
     * Play the next random legal move
     * @return true if game finished, else false
     */
    public boolean playNext() {
        boolean played = false;
        while(!played) {
            int r = random.nextInt(BOARD_MAX);
            int c = random.nextInt(BOARD_MAX);
            int value;
            while ((value = random.nextInt(BOARD_MAX + 1)) == 0) {
                ;
            }
            if (isLegalMove(r, c, value)) {
                move(r, c, value);
                played = true;
            }
        }
        return isGameOver();
    }

    public void printBoard() {
        for (int i = 0; i < BOARD_MAX; i++) {
            for (int j = 0; j < BOARD_MAX; j++) {
                int cell = board[i][j];
                if (cell == EMPTY) {
                    System.out.print(". ");
                } else {
                    System.out.print(String.format("%d ", cell));
                }
            }
            System.out.println();
        }
    }

    public boolean playUntil(int moveNumber) {
        while(moves != moveNumber && !isGameOver()) {
            playNext();
        }
        return moves == moveNumber;
    }

    public class Move implements Comparable {
        public int r, c;
        public ArrayList<Integer> values = new ArrayList<>();
        public Move(int r, int c, ArrayList values) {
            this.r = r;
            this.c = c;
            this.values = values;
        }

        @Override
        public int compareTo(Object o) {
            Move other = (Move)o;
            if (values.size() < other.values.size()) {
                return -1;
            } else if (values.size() > other.values.size()) {
                return 1;
            }
            return 0;
        }
    }

    // find best move: the one with fewest legal candidate values since this keeps search tree narrow.
    public PriorityQueue<Move> findBestMove() {
        PriorityQueue<Move> q = new PriorityQueue<>();

        for (int r = 0; r < BOARD_MAX; r++) {
            for (int c = 0; c < BOARD_MAX; c++) {
                if (board[r][c] == EMPTY && count[r][c] > 0) {
                    ArrayList<Integer> moveValues = new ArrayList<>();
                    for (int i = 1; i < 10; i++) {
                        int v = values[r][c][i];
                        if (v == 0 && isLegalMove(r, c, i)) {
                            moveValues.add(i);
                        }
                    }
                    if (count[r][c] != moveValues.size()) {
                        //throw new IllegalStateException("count array out of sync!");
                    }
                    q.add(new Move(r, c, moveValues));
                }
            }
        }

        return q;
    }

    public boolean solve() {
        boolean solved = false;

        if (isGameOver()) {
            System.out.println("GAME OVER!");
            printBoard();
            return true;
        }

        PriorityQueue<Move> q = findBestMove();
        for(Move move = null; (move = q.poll()) != null; ) {
            for (Integer v : move.values) {
                move(move.r, move.c, v);
                solved = solve();
                if (!solved) {
                    unmove(move.r, move.c);
                } else {
                    return solved;
                }
            }
        }

        return solved;
    }
}
