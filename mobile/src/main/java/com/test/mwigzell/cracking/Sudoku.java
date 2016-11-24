package com.test.mwigzell.cracking;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by mwigzell on 11/23/16.
 */

public class Sudoku {
    static final int BOARD_MAX = 9;
    static final int MOVES_MAX = BOARD_MAX * BOARD_MAX;
    static final int QUADRANT_MAX = 3;
    static final int EMPTY = -1;

    int[][] board;
    int moves;
    int highestMove;
    int lowestUnmove;
    Random random;

    public Sudoku() {
        board = new int[BOARD_MAX][BOARD_MAX];
        clear();
        random = new Random();
    }

    public void clear() {
        for (int i = 0; i < BOARD_MAX; i++) {
            for (int j = 0; j < BOARD_MAX; j++) {
                board[i][j] = EMPTY;
            }
        }
        moves = highestMove = lowestUnmove = 0;

    }

    public int moveNumber() {
        return moves;
    }

    public boolean isLegalMove(int x, int y, int value) {
        boolean rc = false;
        if ( board[x][y] == EMPTY) {
            // check column for duplicate
            for (int i = 0; i < BOARD_MAX; i++) {
                if (board[x][i] == value) {
                    return false;
                }
            }
            // check row for duplicate
            for (int i = 0; i < BOARD_MAX; i++) {
                if (board[i][y] == value) {
                   return false;
                }
            }
            // check quadrant for duplicate
            rc = true;
        }
        return rc;
    }

    public void move(int x, int y, int value) {
        board[x][y] = value;
        moves++;
        if (moves > highestMove) {
            highestMove = moves;
            System.out.println("High water mark=" + moves + " x=" + x + " y=" + y + " value=" + value);
            printBoard();
        }
    }

    public void unmove(int x, int y) {
        if (lowestUnmove == 0 || moves < lowestUnmove) {
            lowestUnmove = moves;
            System.out.println("Unmove=" + moves + " x=" + x + " y=" + y + " value=" + board[x][y]);
        }

        board[x][y] = EMPTY;
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
            int x = random.nextInt(BOARD_MAX);
            int y = random.nextInt(BOARD_MAX);
            int value;
            while ((value = random.nextInt(BOARD_MAX + 1)) == 0) {
                ;
            }
            if (isLegalMove(x, y, value)) {
                move(x, y, value);
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
