package com.test.mwigzell.test;

import com.test.mwigzell.test.Sudoku;

import java.util.PriorityQueue;
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
        sudoku.playUntil(65);

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
        assertFalse(sudoku.isLegalMove(3, 0, 4)); // test col constraint from row 1
        assertTrue(sudoku.isLegalMove(3, 0, 9)); // test valid value for column
        assertFalse(sudoku.isLegalMove(0, 3, 2)); // test row constraint from col 1
        assertTrue(sudoku.isLegalMove(0, 3, 9)); // test valid value for row

        assertFalse(sudoku.isLegalMove(1, 1, 4));
        assertFalse(sudoku.isLegalMove(1, 1, 2));
        assertFalse(sudoku.isLegalMove(1, 1, 6));
        assertFalse(sudoku.isLegalMove(1, 1, 8));
    }

    @Test
    public void testGenerateGame() {
        Sudoku sudoku = new Sudoku();
        sudoku.playUntil(50);

        System.out.println("Moves taken=" + sudoku.moveNumber());
        sudoku.printBoard();
    }

    @Test
    public void testFindBestMove() {
        Sudoku sudoku = new Sudoku();
        sudoku.playUntil(17);
        System.out.println("Moves taken=" + sudoku.moveNumber());
        sudoku.printBoard();

        PriorityQueue<Sudoku.Move> q = sudoku.findBestMove();
        Sudoku.Move move;
        while((move = q.poll()) != null) {
            System.out.println("Found move r=" + move.r + " c=" + move.c);
            for (Integer i : move.values) {
                System.out.println("v=" + i);
            }
        }
    }

    @Test
    public void testRoot() {
        Sudoku sudoku = new Sudoku();
        sudoku.solve();
    }

    int[][] puzzle = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };
    @Test
    public void testPuzzle() {
        Sudoku sudoku = new Sudoku();
        sudoku.loadPuzzle(puzzle);

        System.out.println("Moves taken=" + sudoku.moveNumber());
        sudoku.printBoard();
        boolean solved = sudoku.solve();
        System.out.println("Solved=" + solved);
    }
}
