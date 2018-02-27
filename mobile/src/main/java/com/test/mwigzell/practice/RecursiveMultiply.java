package com.test.mwigzell.practice;

/**
 * Created by mark on 11/18/16.
 */

public class RecursiveMultiply {
    public int mult(int a, int b) {
       if (b == 0) {
           return 0;
       } else {
           return a + mult(a, b-1);
       }
    }
}
