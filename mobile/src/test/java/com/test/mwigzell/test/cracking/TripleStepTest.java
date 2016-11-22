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
        assertEquals(4, tripleStep.count(37));
    }
}
