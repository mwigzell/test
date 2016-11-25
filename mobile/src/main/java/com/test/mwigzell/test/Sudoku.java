package com.test.mwigzell.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by mwigzell on 11/23/16.
 */

public class Sudoku {
    static final int QUADRANT_MAX = Quadrant.QUADRANT_MAX;
    static final int BOARD_MAX = QUADRANT_MAX * QUADRANT_MAX;
    static final int MOVES_MAX = BOARD_MAX * BOARD_MAX;
    static final int EMPTY = Quadrant.EMPTY;

    int[][] board;
    int moves;
    int highestMove;
    int lowestUnmove;
    Random random;

    Quadrant[][] quadrants = new Quadrant[QUADRANT_MAX][QUADRANT_MAX];

    void initQuadrants() {
        for (int r = 0; r < QUADRANT_MAX; r++) {
            for (int c = 0; c < QUADRANT_MAX; c++) {
                quadrants[r][c] = new Quadrant(board, r, c);
            }
        }
    }

    public Sudoku() {
        board = new int[BOARD_MAX][BOARD_MAX];
        quadrants = new Quadrant[QUADRANT_MAX][QUADRANT_MAX];
        initQuadrants();
        random = new Random();
        clear();
    }

    int toQuadrant(int index) {
        int i = (index / QUADRANT_MAX);
        if (i < 0 || i > (QUADRANT_MAX - 1)) {
            index = index;
        }
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
            // check column for duplicate
            for (int i = 0; i < BOARD_MAX; i++) {
                if (board[r][i] == value) {
                    return false;
                }
            }
            // check row for duplicate
            for (int i = 0; i < BOARD_MAX; i++) {
                if (board[i][c] == value) {
                   return false;
                }
            }
            // check quadrant for duplicate
            if (!quadrants[toQuadrant(r)][toQuadrant(c)].isLegalValue(value)) {
                return false;
            }
            rc = true;
        }
        return rc;
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

    public boolean solve() {
        //System.out.println("Entered solve() moves=" + moves);
        boolean solved = false;

        if (isGameOver()) {
            printBoard();
            return solved;
        }
        for (int r = 0; r < BOARD_MAX; r++) {
            for (int c = 0; c < BOARD_MAX; c++) {
                for (int v = 1; v < (BOARD_MAX + 1); v++) {
                    if (isLegalMove(r, c, v)) {
                        move(r, c, v);
                        solved = solve();
                        if (!solved) {
                            unmove(r, c);
                        } else {
                            return solved;
                        }
                    }
                }
            }
        }
        return solved;
    }
}
