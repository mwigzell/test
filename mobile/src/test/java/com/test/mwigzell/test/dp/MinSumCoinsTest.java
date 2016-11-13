package com.test.mwigzell.test.dp;

import com.test.mwigzell.dp.MinSumCoins;

import org.junit.Test;

/**
 * Created by mark on 11/12/16.
 */

public class MinSumCoinsTest {

    @Test
    public void test() {
        MinSumCoins msc = new MinSumCoins();
        int[] coins = new int[]{1, 3, 5};
        int sum = 11;
        int rc = msc.min(coins, sum);
        System.out.println("Minimum # of coins needed to reach sum of " + sum + " is " + rc);
    }
}
