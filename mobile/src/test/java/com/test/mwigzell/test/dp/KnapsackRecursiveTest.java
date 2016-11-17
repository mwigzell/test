package com.test.mwigzell.test.dp;

import com.test.mwigzell.dp.Knapsack;
import com.test.mwigzell.dp.KnapsackRecursive;

import org.junit.Test;

/**
 * Created by mark on 11/12/16.
 */

public class KnapsackRecursiveTest {

    @Test
    public void test() {

        int[] values = new int[]{100, 120, 60};
        int[] weights = new int[]{20, 30, 10};
        int weight = 50;
        KnapsackRecursive knapsack = new KnapsackRecursive();
        int rc = knapsack.knapSackRecursive(weight, weights, values, values.length);
        System.out.println("Maximum value possible in knapsack is " + rc);
    }
}
