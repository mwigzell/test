package com.test.mwigzell.test.test;

import com.test.mwigzell.test.LargestSumArray;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mark on 11/8/16.
 */

public class LargestSumArrayTest {
    @Test
    public void testLargestSumArray() {
        LargestSumArray l = new LargestSumArray();
        int[] numbers = new int[] {1, 2, 3, 4, 5, -5, -4, -3, -2, -1, -50, 20, 30, -10, 100};

        int max = l.largestSumArray2(numbers);

        System.out.println("max sum array = " + max);
        assertEquals(140, max);
    }
 }
