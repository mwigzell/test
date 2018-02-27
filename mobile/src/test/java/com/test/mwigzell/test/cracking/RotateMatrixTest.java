package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.RotateMatrix;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by mark on 11/20/16.
 */

public class RotateMatrixTest {
    int[][] matrix;

    @Before
    public void setup() {
        matrix = new int[][] {
                {'A','A','A','A','A','A'},
                {'B','B','B','B','B','B'},
                {'C','C','C','C','C','C'},
                {'D','D','D','D','D','D'},
                {'E','E','E','E','E','E'},
                {'F','F','F','F','F','F'}
        };
    }

    public void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(Character.valueOf((char)matrix[i][j]));
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        RotateMatrix rm = new RotateMatrix();
        rm.rotate(matrix);
        printMatrix(matrix);
    }

    @Test
    public void testPractice() {
        com.test.mwigzell.practice.RotateMatrix rm = new com.test.mwigzell.practice.RotateMatrix();
        rm.rotate(matrix);
        printMatrix(matrix);
    }
}
