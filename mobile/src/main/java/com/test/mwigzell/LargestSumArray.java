package com.test.mwigzell;

/**
 * Created by mark on 11/8/16.
 */

public class LargestSumArray {
    public int largestSumArray(int[] numbers) {
        int max = 0;

        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            for (int j = i; j < numbers.length; j++) {
                sum += numbers[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
