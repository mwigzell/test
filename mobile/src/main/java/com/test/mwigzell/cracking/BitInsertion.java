package com.test.mwigzell.cracking;

/**
 * Created by mwigzell on 11/23/16.
 */

public class BitInsertion {
    public int insert(int n, int m, int i, int j) {
        int maskWidth = j - i;
        int mask = 1;
        for (int w = 0; w < maskWidth; w++) {
            mask <<= 1;
            mask |= 1;
        }
        // move mask bits over by i
        mask <<= i;

        // clear bits in n corresponding to mask
        n &= ~mask;
        // shift over m by i;
        int value = m << i;

        // set value int n
        n |= value;
        return n;
    }
}
