package com.test.mwigzell.dp;

import java.util.ArrayList;

/**
 * Created by mark on 11/12/16.
 * Find minimum number of coins needed to add up to a given sum, given a list of coin denominations
 */

public class MinSumCoins {
    static final int INFINITY = 99;

    public class State {
        int prevIndex;
        int coin;
        int min;

        public State() {
            this.prevIndex = -1;
            this.coin = INFINITY;
            this.min = INFINITY;
        }
    }

    /**
     *
     * @param coins
     * @param sum
     * @return value of state whose index is sum or zero
     */
    public int min(int[] coins, int sum) {
        // init partial states leading up to sum
        State[] states = new State[sum + 1];
        for(int i = 0; i <= sum; i++) {
            states[i] = new State();
        }

        states[0].prevIndex = 0;
        states[0].coin = 0;
        states[0].min = 0;
        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < coins.length; j++) {
                int prevSum = i - coins[j];
                if (prevSum >= 0) {
                    int prevMin = states[prevSum].min;
                    if ((coins[j] <= i) && (prevMin + 1) < states[i].min) {
                        states[i].min = prevMin + 1;
                        states[i].coin = coins[j];
                        states[i].prevIndex = prevSum;
                    }
                }
            }
        }

        // print states
        System.out.println("Sum Min Coin (previous Sum)");
        for (int i = 0; i < states.length; i++) {
            System.out.println(i + " " + states[i].min + " " + states[i].coin + "(" + states[i].prevIndex + ")");
        }
        // return minimum number of coins to reach sum
        return states[sum].min;
    }
}
