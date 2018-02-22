package com.test.mwigzell.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mark on 2/21/18.
 */

public class PermutePractice {
    List<String> list;

    private void permute(String prefix, String s) {
        if (s.length() == 1) {
            list.add(prefix + s);
            return;
        }

        for (int i = 0; i < (s.length()); i++) {
            permute(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1));
        }
    }

    public List<String> compute(String s) {
        list = new ArrayList<String>();
        permute("", s);
        return list;
    }
}
