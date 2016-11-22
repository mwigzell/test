package com.test.mwigzell.cracking;

/**
 * Created by mark on 11/18/16.
 */

public class RecursiveMultiply {
    int helper(int bigger, int smaller) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }

        int s = smaller>>1;
        int halfprod = helper(bigger, s);
        if(smaller % 2 == 1) {
            return halfprod + halfprod + bigger;
        } else {
            return halfprod + halfprod;
        }
    }

    public int mult(int a, int b) {
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);
        return helper(bigger, smaller);
    }
}
