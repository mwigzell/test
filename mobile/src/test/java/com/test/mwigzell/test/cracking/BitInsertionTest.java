package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.BitInsertion;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mwigzell on 11/23/16.
 */

public class BitInsertionTest {
    @Test
    public void test() {
        BitInsertion bi = new BitInsertion();
        int n = 0x400;
        int m = 0x13;
        int i = 2;
        int j = 6;
        int e = 0x44c;
        int r = bi.insert(n, m, i, j);
        System.out.println("i=" + i + " j=" + j);
        System.out.println("m=" + Integer.toBinaryString(m));
        System.out.println("n=" + Integer.toBinaryString(n));
        System.out.println("r=" + Integer.toBinaryString(r));
        System.out.println("e=" + Integer.toBinaryString(e));
        assertEquals(e, r);
    }
}
