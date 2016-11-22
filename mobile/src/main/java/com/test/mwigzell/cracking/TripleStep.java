package com.test.mwigzell.cracking;

import java.util.Arrays;

/**
 * Created by mark on 11/16/16.
 */

public class TripleStep {
    int[] memo;

    public int count(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return count(n, memo);
    }

    public int count(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] != -1) {
            return memo[n];
        } else {
            memo[n] = count(n - 1, memo) + count(n - 2, memo) + count(n - 3, memo);
            return memo[n];
        }
    }
}
