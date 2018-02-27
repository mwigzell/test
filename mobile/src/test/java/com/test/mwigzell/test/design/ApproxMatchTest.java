package com.test.mwigzell.test.design;

import com.test.mwigzell.design.ApproxMatch;
import com.test.mwigzell.design.LcsMatch;
import com.test.mwigzell.design.SubstringMatch;

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
    public void testSubtringMatch() {
        SubstringMatch sut = new SubstringMatch();
        s = "ecda";
        t = "xyzeccaxyz";
        int distance = sut.stringCompare(s, t);

        assertEquals(1, distance);
    }

    @Test
    public void testLcsMatch() {
        LcsMatch sut = new LcsMatch();
        s = "eca";
        t = "xeycza";
        int distance = sut.stringCompare(s, t);

        assertEquals(3, distance);
    }

    // according to Skienna in Algorithm Design page 289
    // we should be able to input the sorted
    // sequence and get the longest montonic increasing
    // substring, but how to read it out?
    // this test just gets a indel sequence that will
    // create s from t, but that is not it!
    @Test
    public void testMaximumMonotonicSubsequenceMatch() {
        LcsMatch sut = new LcsMatch();
        s = "2468";
        t = "92847668";
        int distance = sut.stringCompare(s, t);

        assertEquals(4, distance);
    }
}
