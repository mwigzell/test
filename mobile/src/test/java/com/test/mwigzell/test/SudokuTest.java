package com.test.mwigzell.test;

import com.test.mwigzell.test.Sudoku;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by mwigzell on 11/23/16.
 */

public class SudokuTest {
    @Test
    public void test() {
        Sudoku sudoku = new Sudoku();
        sudoku.playUntil(20);

        System.out.println("Moves taken=" + sudoku.moveNumber());
        sudoku.printBoard();
        boolean solved = sudoku.solve();
        System.out.println("Solved=" + solved);
    }

    @Test
    public void testConstraints() {
        Sudoku sudoku = new Sudoku();
        sudoku.move(0, 0, 1); sudoku.move(0, 1, 2); sudoku.move(0, 2, 3);
        sudoku.move(1, 0, 4);                       sudoku.move(1, 2, 6);
        sudoku.move(2, 0, 7); sudoku.move(2, 1, 8); sudoku.move(2, 2, 9);

        assertFalse(sudoku.isLegalMove(1, 1, 1));
        assertTrue(sudoku.isLegalMove (1, 1, 5));
    }
}
