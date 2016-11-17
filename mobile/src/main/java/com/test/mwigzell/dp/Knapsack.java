package com.test.mwigzell.dp;

// A Dynamic Programming based solution for 0-1 Knapsack problem
public class Knapsack {

    // A utility function that returns maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static void printValueTable(int[][] K, int W, int n) {
        System.out.println("Value table:");
        for (int i = 0; i <= W; i++) {
            System.out.print(String.format("%3d ", i));
        }
        System.out.println();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.print(String.format("%3d ", K[i][j]));
            }
            System.out.println();
        }
    }

    // Returns the maximum value that can be put in a knapsack of capacity W
    public static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        printValueTable(K, W, n);

        return K[n][W];
    }

}