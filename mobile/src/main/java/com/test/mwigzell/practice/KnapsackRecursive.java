package com.test.mwigzell.practice;

/**
 * Created by mark on 2/27/18.
 */

public class KnapsackRecursive {

    int weight(int[] weights, int i) {
        return weights[i - 1];
    }

    int value(int[] values, int i) {
        return values[i - 1];
    }

    public int knapSackRecursive(int W, int[] weights, int[] values, int n) {
        int value = 0;

        if (n == 0) {
            return 0;
        }

        if (weight(weights, n) > W) {
            return knapSackRecursive(W, weights, values, n - 1);
        }
        value = value(values, n);
        value = Math.max(value + knapSackRecursive(W - weight(weights, n), weights, values, n-1),
                knapSackRecursive(W, weights, values, n-1));


        return value;
    }
}
