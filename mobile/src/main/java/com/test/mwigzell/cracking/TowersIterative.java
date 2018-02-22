package com.test.mwigzell.cracking;

import java.util.Stack;

/**
 * Created by mark on 11/18/16.
 */

public class TowersIterative {
    class Hanoi {
        int n;
        Stack<Integer> origin;
        Stack<Integer> dest;
        Stack<Integer> buffer;
        public Hanoi(int n, Stack<Integer> origin, Stack<Integer> dest, Stack<Integer> buffer) {
            this.n = n;
            this.origin = origin;
            this.dest = dest;
            this.buffer = buffer;
        }
    }
    void moveDisk(Stack<Integer> from, Stack<Integer> to) {
        to.push(from.pop());
    }

    public void moveDisks(int n, Stack<Integer> origin, Stack<Integer> dest, Stack<Integer> buffer) {
        Hanoi hanoi = new Hanoi(n, origin, dest, buffer);
        Stack<Hanoi> stack = new Stack<Hanoi>();
        stack.push(hanoi);

        while(!stack.isEmpty()) {
            hanoi = stack.pop();
            if (hanoi.n > 0) {
                stack.push(new Hanoi(hanoi.n - 1, hanoi.origin, hanoi.buffer, hanoi.dest));
                moveDisk(hanoi.origin, hanoi.dest);
                stack.push(new Hanoi(hanoi.n - 1, hanoi.buffer, hanoi.dest, hanoi.origin));
            }
        }
    }
}
