package com.test.mwigzell.test.dp;

import com.test.mwigzell.dp.Knapsack2;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by mark on 11/12/16.
 */

public class Knapsack2Test {

    @Test
    public void test() {
        int[] values = new int[]{60, 100, 120};
        int[] weights = new int[]{10, 20, 30};
        int weight = 50;
        int rc = Knapsack2.knapsack(weight, weights, values);
        System.out.println("Maximum value possible in knapsack is " + rc);
        assertTrue(rc == 220);
    }
}
