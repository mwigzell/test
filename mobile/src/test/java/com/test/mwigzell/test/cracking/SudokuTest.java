package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.Sudoku;

import org.junit.Test;

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
}
