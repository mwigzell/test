package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.RotateMatrix;

import org.junit.Test;

/**
 * Created by mark on 11/20/16.
 */

public class RotateMatrixTest {
    @Test
    public void test() {
        int[][] matrix = new int[][] {
                {'A','A','A','A','A','A'},
                {'B','B','B','B','B','B'},
                {'C','C','C','C','C','C'},
                {'D','D','D','D','D','D'},
                {'E','E','E','E','E','E'},
                {'F','F','F','F','F','F'}
        };
        RotateMatrix rm = new RotateMatrix();
        rm.rotate(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(Character.valueOf((char)matrix[i][j]));
            }
            System.out.println();
        }
    }
}
