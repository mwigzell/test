package com.test.mwigzell.test.test;

import com.test.mwigzell.test.PascalTriangleGenerator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class PascalTriangeGeneratorTest {
    @Test
    public void generate() throws Exception {
        PascalTriangleGenerator.printPascalTriangle(10);
    }
}