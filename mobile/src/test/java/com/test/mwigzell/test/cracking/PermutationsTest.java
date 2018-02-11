package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.Permutations;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by mark on 11/18/16.
 */

public class PermutationsTest {
    @Test
    public void testNoDups() {
        Permutations perms = new Permutations();
        ArrayList<String> list = perms.computeNoDups("abcd");
        for(String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testNonRecursive() {
        Permutations perms = new Permutations();
        perms.computeNoRecursion("abcde");
    }
}
