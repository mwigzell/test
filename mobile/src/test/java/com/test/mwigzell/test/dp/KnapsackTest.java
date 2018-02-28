package com.test.mwigzell.test.dp;

import com.test.mwigzell.dp.Knapsack;
import com.test.mwigzell.dp.KnapsackRecursive;
import com.test.mwigzell.dp.MinSumCoins;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mark on 11/12/16.
 */

public class KnapsackTest {
    int[] values = new int[]{60, 100, 120};
    int[] weights = new int[]{10, 20, 30};
    int weight = 50;

    @Test
    public void test() {
        Knapsack knapsack = new Knapsack();
        int rc = knapsack.knapSack(weight, weights, values, values.length);
        System.out.println("Maximum value possible in knapsack is " + rc);
        assertEquals(220, rc);
    }

    @Test
    public void testPractice() {
        com.test.mwigzell.practice.KnapSack knapsack = new com.test.mwigzell.practice.KnapSack(weights, values);
        int rc = knapsack.knapSack(weight);
        System.out.println("Maximum value possible in knapsack is " + rc);
        assertEquals(220, rc);
    }
}
