package com.test.mwigzell.test;

/**
 * Created by mwigzell on 2/2/18.
 */

import java.util.ArrayList;
import java.util.List;

/**

 Pascal Triangle

 1
 1       1
 1       2       1
 1       3       3       1
 1       4       6       4       1
 1       5       10      10      5       1

 printPascalTriangle(int height)

 1
 1 1
 1 2 1
 1 3 3 1
 1 4 6 4 1
 1 5 10 10 5 1

 */
public class PascalTriangleGenerator {
    static int height;

    public static void main(String args[]) {
        System.out.println("Hello Jason - Java!");
        printPascalTriangle(5);
    }

    /**
     * Get the next sum based on the current index in the current row and the content of the
     * previous row. Do this by summing the index value with the "index minus one" value if possible.
     * If the index is invalid then no addition is done
     * If the row is null it is assumed to be the first or zeroth row.
     * @param row The previous row
     * @param index The current index into the current row
     * @return the sum for the position referenced in the row by the index
     */
    static private int getNextSum(ArrayList<Integer> row, int index) {
        int sum = 1;
        if (row != null) {
            if (index < row.size()) {
                sum = row.get(index);
                index -= 1;
                if (index >= 0) {
                    sum += row.get(index);
                }
            }
        }
        return sum;
    }

    /**
     * Print Pascal's triangle for height rows.
     * @param height
     */
    public static void printPascalTriangle(int h) {
        height = h;
        ArrayList<Integer> prevRow = null;

        // for each row to output, starting from the first row and going up to height rows.
        for (int i = 0; i < height; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            // for each position in the new row:
            for (int j = 0; j <= i; j++) {
                // calculate the value at each position by indexing into the previous row.
                int sum = getNextSum(prevRow, j);
                row.add(sum);
            }
            printRow(row);

            // we're done with row, remember it for calculating the next row
            prevRow = row;
        }
    }
    static void printRow(List<Integer> list) {
        int padding = height - list.size() + 1;
        System.out.print(String.format("%" + padding + "s", ""));
        for(int i : list) {
            System.out.print(String.format("%4d", i));
        }
        System.out.println();
    }
}
