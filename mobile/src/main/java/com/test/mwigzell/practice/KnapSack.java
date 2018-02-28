package com.test.mwigzell.practice;

/**
 * Created by mark on 2/27/18.
 */

public class KnapSack {
    int[] weights;
    int[] values;
    int n;

    public KnapSack(int[] weights, int[] values) {
        this.weights = weights;
        this.values = values;
        this.n = values.length;
    }

    int weight(int i) {
        return weights[i - 1];
    }

    int value(int i) {
        return values[i - 1];
    }

    public int knapSack(int W) {
        int[][] m = new int[n + 1][W + 1];

        for (int v = 0; v <= n; v++) {
            for (int w = 0; w <= W; w++) {
                if (v == 0 || w == 0) {
                    m[v][w] = 0;
                }
                else if (weight(v) <= w) {
                    m[v][w] = Math.max(m[v-1][w - weight(v)] + value(v), value(v));
                } else {
                    m[v][w] = m[v -1][w];
                }
            }
        }
        print(m);
        return m[n][W];
    }

    void print(int[][] m) {
        System.out.println("m[][]:");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(String.format("%3d ", m[i][j]));
            }
            System.out.println("");
        }
    }
}
