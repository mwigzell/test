package com.test.mwigzell.dp;

/**
 * Created by mwigzell on 2/3/18.
 */

public class Knapsack2 {
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

    public static int knapsack(int W, int wt[], int val[]) {
        int N = wt.length; // Get the total number of items. Could be wt.length or val.length. Doesn't matter
        int[][] V = new int[N + 1][W + 1]; //Create a matrix. Items are in rows and weight at in columns +1 on each side
        //What if the knapsack's capacity is 0 - Set all columns at row 0 to be 0
        for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }
        //What if there are no items at home.  Fill the first row with 0
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        for (int item=1;item<=N;item++){
            int cur = item - 1; // current table index (wt or val)
            //Let's fill the values row by row
            for (int weight=1;weight<=W;weight++){
                //Is the current items weight less than or equal to running weight
                if (wt[cur]<=weight){
                    //Given a weight, check if the value of the current item + value of the item that we could afford with the remaining weight
                    //is greater than the value without the current item itself
                    V[item][weight]=Math.max (val[cur]+V[item - 1][weight-wt[cur]], V[item - 1][weight]);
                }
                else {
                    //If the current item's weight is more than the running weight, just carry forward the value without the current item
                    V[item][weight]=V[item - 1][weight];
                }
            }
        }

        printValueTable(V, W, N);

        return V[N][W];
    }
}