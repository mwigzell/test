package com.test.mwigzell.design;

/**
 * Design Algorithms page 206. Partition problem: for list of numbers "s[]"
 * partition list into "k" sections of maximum sums but as close to even
 * sums as possible.
 */

public class Partition {
    static final int MAXN = 15;
    static final int MAXINT = Integer.MAX_VALUE;

    public void partition(int s[], int n, int k) {
        int m[][] = new int[MAXN + 1][MAXN + 1]; // DP table for values
        int d[][] = new int[MAXN + 1][MAXN + 1]; // DP table for dividers
        int p[] = new int[MAXN + 1]; // prefix sum array
        int cost; // test split cost
        int i, j, x; // counters

        // init prefix sums
        p[0] = 0;
        for (i = 1; i <= n; i++) {
            p[i] = p[i-1] + s[i-1]; // I changed s[i] to s[i-1] to include first element in s
        }

        // init boundaries
        for (i = 1; i <= n; i++) {
            m[i][1] = p[i];
        }
        for (j = 1; j <= k; j++) {
            m[1][j] = s[1];
        }

        // evaluate main recurrence
        for (i = 2; i <= n; i++) {
            for (j = 2; j <= k; j++) {
                m[i][j] = MAXINT;
                for (x = 1; x <= (i - 1); x++) {
                    cost = Math.max(m[x][j - 1], p[i] - p[x]);
                    if (m[i][j] > cost) {
                        m[i][j] = cost;
                        d[i][j] = x;
                    }
                }
            }
        }
        reconstructPartition(s, d, n, k);
    }

    void reconstructPartition(int[] s, int[][] d, int n, int k) {
        if (k == 1) {
            printBooks(s, 0, n); // I changed start to 0 from 1
        } else {
            reconstructPartition(s, d, d[n][k], k - 1);
            printBooks(s, d[n][k] + 1, n);
        }
    }

    void printBooks(int[] s, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(String.format(" %d ", s[i]));
        }
        System.out.println("");
    }
}
