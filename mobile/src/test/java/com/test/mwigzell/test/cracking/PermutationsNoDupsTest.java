package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.PermutationsNoDups;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by mark on 11/18/16.
 */

public class PermutationsNoDupsTest {
    @Test
    public void test() {
        PermutationsNoDups perms = new PermutationsNoDups();
        ArrayList<String> list = perms.compute("abcd");
        for(String s : list) {
            System.out.println(s);
        }
    }
}
