package com.test.mwigzell.cracking;

import java.util.Stack;

/**
 * Created by mark on 11/18/16.
 */

public class Towers {
    void moveDisk(Stack<Integer> from, Stack<Integer> to) {
        to.push(from.pop());
    }

    public void moveDisks(int n, Stack<Integer> origin, Stack<Integer> dest, Stack<Integer> buffer) {
        if (n > 0) {
            moveDisks(n - 1, origin, buffer, dest);
            moveDisk(origin, dest);
            moveDisks(n - 1, buffer, dest, origin);
        }
    }
}
