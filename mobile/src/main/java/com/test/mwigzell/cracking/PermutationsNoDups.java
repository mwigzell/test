package com.test.mwigzell.cracking;

import java.util.ArrayList;

/**
 * Created by mark on 11/18/16.
 */

public class PermutationsNoDups {
    void helper(String s, String prefix, ArrayList<String> list) {
        if (s.length() == 0) {
            list.add(prefix);
        } else {
            for (int i = 0; i < s.length(); i++) {
                String c = s.substring(i, i+1);
                String rem = s.substring(0, i) + s.substring(i+1);
                helper(rem, prefix + c, list);
            }
        }
    }
    public ArrayList<String> compute(String s) {
        ArrayList<String> list = new ArrayList<>();
        helper(s, "", list);
        return list;
    }
}
