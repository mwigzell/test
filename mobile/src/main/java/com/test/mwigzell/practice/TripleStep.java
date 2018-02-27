package com.test.mwigzell.practice;

/**
 * Created by mwigzell on 2/22/18.
 */

public class TripleStep {

    public int count(int n) {
        if (n < 0) {
            return 0;
        }
        else if (n == 0) {
            return 1;
        } else  {
            return count(n-1) + count(n-2) + count(n-3);
        }
    }
}
