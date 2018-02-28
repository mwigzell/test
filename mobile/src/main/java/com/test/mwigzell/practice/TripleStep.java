package com.test.mwigzell.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwigzell on 2/22/18.
 */

public class TripleStep {
    Map<Integer, Integer> memo;

    public TripleStep() {
        memo = new HashMap<>();
    }

    public int count(int n) {
        if (n < 0) {
            return 0;
        }
        else if (n == 0) {
            return 1;
        } else  {
            if (!memo.containsKey(n)) {
                memo.put(n, count(n - 1) + count(n - 2) + count(n - 3));
            }
            return memo.get(n);
        }
    }
}
