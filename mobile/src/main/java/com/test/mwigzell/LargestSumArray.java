package com.test.mwigzell;

/**
 * Created by mark on 11/8/16.
 */

public class LargestSumArray {
    /**
     * complexity: O(n^2)
     * @param numbers
     * @return
     */
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

    /**
     * complexity: O(n)
     * @param numbers
     * @return
     */
    public int largestSumArray2(int[] numbers) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < numbers.length; i++) {
            current += numbers[i];

            if (current <= numbers[i]) {
                current = numbers[i];
            }
            if (current > max) {
                max = current;
            }
        }

        return max;
    }
}
