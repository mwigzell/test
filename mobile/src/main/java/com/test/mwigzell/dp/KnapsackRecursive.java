package com.test.mwigzell.dp;

// A Dynamic Programming based solution for 0-1 Knapsack problem
public class KnapsackRecursive {


    // Returns the maximum value that can be put in a knapsack of capacity W
    public int knapSackRecursive(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n-1] > W) {
            return knapSackRecursive(W, wt, val, n-1);
        }

        return Math.max(val[n-1] + knapSackRecursive(W - wt[n-1], wt, val, n-1), knapSackRecursive(W, wt, val, n-1));
    }

}