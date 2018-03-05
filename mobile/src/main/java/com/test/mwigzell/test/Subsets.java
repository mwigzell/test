package com.test.mwigzell.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mark on 3/1/18.
 */

public class Subsets {
    //return an array of all possible subsets
    public List<List<Integer>> subsets(List<Integer> set) {
        List<List<Integer>> list = compute(set, set.size());
        return list;
    }

    List<List<Integer>> compute(List<Integer> set, int n) {
        List<List<Integer>> list = new ArrayList<>();
        if (n == 0) {
            list.add(new ArrayList<>());
        } else {
            List<List<Integer>> subsets = compute(set, n - 1);
            list.addAll(subsets);
            int v = set.get(n - 1);

            // for each subset in subsets, add it into list and
            // create new set with the subset and v and add it to list)
            for (List<Integer> subset : subsets) {
                List<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(v);
                list.add(newSubset);
            }
        }
        return list;
    }
}
