package com.test.mwigzell.test.design;

import com.test.mwigzell.design.ApproxMatch;
import com.test.mwigzell.design.LongestCommonSubsequence;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mark on 2/21/18.
 */

public class ApproxMatchTest {
    String s = "thou shalt not";
    String t = "you should not";

    @Before
    public void setup() {
    }

    @Test
    public void test() {
        ApproxMatch sut = new ApproxMatch();
        int distance = sut.stringCompare(s, t);

        assertEquals(5, distance);
    }

    @Test
    public void testEmptySource() {
        ApproxMatch sut = new ApproxMatch();
        s = "";
        t = "yes";
        int distance = sut.stringCompare(s, t);

        assertEquals(3, distance);
    }

    @Test
    public void testEmptyDest() {
        ApproxMatch sut = new ApproxMatch();
        s = "Yes";
        t = "";
        int distance = sut.stringCompare(s, t);

        assertEquals(3, distance);
    }

    @Test
    public void testEmptyStrings() {
        ApproxMatch sut = new ApproxMatch();
        s = "";
        t = "";
        int distance = sut.stringCompare(s, t);

        assertEquals(0, distance);
    }

    @Test
    public void testLcs() {
        LongestCommonSubsequence sut = new LongestCommonSubsequence();
        s = "democrat";
        t = "republican";
        int distance = sut.stringCompare(s, t);

        assertEquals(8, distance);
    }
}
