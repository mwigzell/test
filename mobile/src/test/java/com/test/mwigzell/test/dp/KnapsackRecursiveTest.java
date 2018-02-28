package com.test.mwigzell.test.dp;


import com.test.mwigzell.dp.KnapsackRecursive;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by mark on 11/12/16.
 */

public class KnapsackRecursiveTest {
    int[] values = new int[]{100, 120, 60};
    int[] weights = new int[]{20, 30, 10};
    int weight = 50;

    @Test
    public void test() {
        KnapsackRecursive knapsack = new KnapsackRecursive();
        int rc = knapsack.knapSackRecursive(weight, weights, values, values.length);
        System.out.println("Maximum value possible in knapsack is " + rc);
        assertEquals(220, rc);
    }

    @Test
    public void testPractice() {
        com.test.mwigzell.practice.KnapsackRecursive knapsack = new com.test.mwigzell.practice.KnapsackRecursive();
        int rc = knapsack.knapSackRecursive(weight, weights, values, values.length);
        System.out.println("Maximum value possible in knapsack is " + rc);
        assertEquals(220, rc);
    }
}
