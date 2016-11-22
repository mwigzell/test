package com.test.mwigzell.cracking;

/**
 * Created by mark on 11/20/16.
 */

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int edge = 0; edge < n/2; edge++) {
            int first = edge;
            int last = n - 1 - edge;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                //System.out.println("first=" + first + " last=" + last + " i=" + i + " offset=" + offset);
                int top = matrix[first][i];
                // four way swap rotates clockwise
                /*matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top;*/
                // four way swap rotates counter-clockwise
                matrix[first][i] = matrix[i][last];
                matrix[i][last] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[last-offset][first];
                matrix[last-offset][first] = top;
            }
        }
    }
}
