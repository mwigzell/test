package com.test.mwigzell.practice;

/**
 * Created by mark on 11/20/16.
 */

public class RotateMatrix {
    public void rotate(int[][] matrix) {
       int distance = matrix.length;
       for (int ring = 0; ring < distance/2; ring++) {
           for (int i = ring; i < distance - ring -1; i++) {
               int end = distance - i - 1;
               int last = distance - ring - 1;
               int tmp = matrix[i][ring];
               matrix[i][ring] = matrix[ring][end];
               matrix[ring][end] = matrix[end][last];
               matrix[end][last] = matrix[last][i];
               matrix[last][i] = tmp;

               //System.out.println("ring=" + ring + " offset=" + offset + " i=" + i);
               //printMatrix(matrix);
           }
       }
    }

    public void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(Character.valueOf((char)matrix[i][j]));
            }
            System.out.println();
        }
    }
}
