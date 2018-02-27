package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.TripleStep;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mark on 11/16/16.
 */

public class TripleStepTest {
    @Test
    public void test() {
        TripleStep tripleStep = new TripleStep();
        assertEquals(13, tripleStep.count(5));
    }

    @Test
    public void testPractice() {
        com.test.mwigzell.practice.TripleStep tripleStep = new com.test.mwigzell.practice.TripleStep();
        assertEquals(12, tripleStep.count(7));
    }
}
