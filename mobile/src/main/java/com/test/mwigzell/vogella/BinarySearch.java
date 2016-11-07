package com.test.mwigzell.vogella;

/**
 * Created by mark on 11/5/16.
 */

public class BinarySearch {
    public static boolean contains(int[] numbers, int v) {
        boolean rc = false;

        int low = 0;
        int high = numbers.length;
        while(low <= high) {
            int middle = low + (high - low)/2;
            if (v < numbers[middle]) {
                high = middle - 1;
            } else if (v > numbers[middle]) {
                low = middle + 1;
            } else {
                rc = true;
                break;
            }
        }

        return rc;
    }
}
