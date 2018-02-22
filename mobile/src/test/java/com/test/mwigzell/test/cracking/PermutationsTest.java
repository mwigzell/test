package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.Permutations;
import com.test.mwigzell.practice.PermutePractice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by mark on 11/18/16.
 */

public class PermutationsTest {
    @Test
    public void testNoDups() {
        Permutations perms = new Permutations();
        ArrayList<String> list = perms.computeNoDups("abcd");
        assertEquals(24, list.size());
        for(String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testNonRecursive() {
        Permutations perms = new Permutations();
        perms.computeNoRecursion("abcde");
    }

    @Test
    public void testPermutePractice() {
        PermutePractice perms = new PermutePractice();
        List<String> list = perms.compute("abcd");
        assertEquals(24, list.size());
        list.forEach(s -> System.out.println(s));
    }
}
