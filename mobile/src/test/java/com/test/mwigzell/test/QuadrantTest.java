package com.test.mwigzell.test;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by mwigzell on 11/24/16.
 */
public class QuadrantTest {
    void clear(int[][] board) {
        for (int i = 0; i < Sudoku.BOARD_MAX; i++) {
            for (int j = 0; j < Sudoku.BOARD_MAX; j++) {
                board[i][j] = Sudoku.EMPTY;
            }
        }
    }

    @Test
    public void test() {
        int[][] board = new int[Sudoku.BOARD_MAX][Sudoku.BOARD_MAX];
        clear(board);
        board[0][0] = 1; board[0][1] = 2; board[0][2] = 3;
        board[1][0] = 4;                  board[1][2] = 6;
        board[2][0] = 7; board[2][1] = 8; board[2][2] = 9;
        Quadrant q = new Quadrant(board, 0, 0);
        q.constrainValues();
        assertTrue(q.isLegalValue(5));
        assertFalse(q.isLegalValue(1));
    }

    @Test
    public void testAddConstraint() {
        int[][] board = new int[Sudoku.BOARD_MAX][Sudoku.BOARD_MAX];
        clear(board);
        Quadrant q = new Quadrant(board, 0, 0);
        q.addConstraint(1);
        assertFalse(q.isLegalValue(1));
        q.removeConstraint(1);
        assertTrue(q.isLegalValue(1));
    }
}
