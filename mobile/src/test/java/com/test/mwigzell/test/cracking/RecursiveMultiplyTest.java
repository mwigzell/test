package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.RecursiveMultiply;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mark on 11/18/16.
 */

public class RecursiveMultiplyTest {
    @Test
    public void test() {
        RecursiveMultiply rm = new RecursiveMultiply();

        assertEquals(77, rm.mult(11, 7));
    }
}
