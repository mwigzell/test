package com.test.mwigzell.vogella;

/**
 * Created by mark on 11/5/16.
 */

public class GreatestCommonDevisor {
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }
}
