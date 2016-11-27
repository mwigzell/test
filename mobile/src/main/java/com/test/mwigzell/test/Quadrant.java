package com.test.mwigzell.test;

import java.util.Arrays;

/**
 * Created by mwigzell on 11/24/16.
 */
public class Quadrant {
    public static final int QUADRANT_MAX = 3;
    public static final int EMPTY = 0;

    boolean[] values; // boolean array of values in this quadrant: (1-9), 0 value is not used.
    int[][] board;
    int qr, qc; // quadrant coordinate (# quadrants == BOARD_MAX/QUADRANT_MAX)

    public Quadrant(int[][] board, int r, int c) {
        this.board = board;
        this.qr = r;
        this.qc = c;
        values = new boolean[9+1]; // store all 9 possible cell values (1-9): value IS the index.
    }

    /**
     * calculate the board row from a quadrant matrix row
     * @param r
     * @return row in the board corresponding to a quadrant row
     */
    int boardRow(int r) {
        return r + (qr * QUADRANT_MAX);
    }

    /**
     * calculate the board col from a quadrant matrix col
     * @param c
     * @return col in the board corresponding to a quadrant col
     */
    int boardCol(int c) {
        return c + (qc * QUADRANT_MAX);
    }

    /**
     * check that value satisfies the quadrant constraint (no value may occur more than once in a quadrant)
     * @param value
     * @return
     */
    public boolean isLegalValue(int value) {
        return !values[value];
    }

    void addConstraint(int value) {
        values[value] = true;
    }

    void removeConstraint(int value) {
        values[value] = false;
    }

    /**
     * constrain the values in this quadrant so values only has legal moves
     */
    public void constrainValues() {
        Arrays.fill(values, false);
        for (int r = 0; r < QUADRANT_MAX; r++) {
            for (int c = 0; c < QUADRANT_MAX; c++) {
                int v = board[boardRow(r)][boardCol(c)];
                if (v != EMPTY) {
                    addConstraint(v);
                }
            }
        }
    }

    /**
     * Get the internal boolean array of values in this quadrant: avail values are false
     * @return boolean array indexed by value from 1 - 9 inclusive. 0 value is not used.
     */
    public boolean[] getValues() {
        return values;
    }
}