package com.test.mwigzell.test.test;

import com.test.mwigzell.test.Subsets;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mark on 3/1/18.
 */

public class SubsetTest {
    int[] s = {1, 2, 3, 4};
    List<Integer> set;

    @Before
    public void setup() {
        set = new ArrayList<>();
        for (int i=0; i < s.length; i++) {
            set.add(s[i]);
        }
    }
    void print(List<List<Integer>> subsets) {
        for(List<Integer> subset : subsets) {
            System.out.print("{");
            for (int i : subset) {
                System.out.print(String.format("%2d ", i));
            }
            System.out.println("}");
        }
    }

    @Test
    public void testSubsets() {
        Subsets subsets = new Subsets();
        print(subsets.subsets(set));
    }
}
