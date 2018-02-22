package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.Towers;
import com.test.mwigzell.cracking.TowersIterative;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mark on 11/18/16.
 */

public class TowersTest {
    static final int N = 5;
    Stack<Integer> a, b, c;

    @Before
    public void setup() {
        a = new Stack<>();
        b = new Stack<>();
        c = new Stack<>();
        for (int i = 1; i <= N; i++) {
            a.push(i);
        }
    }

    private void validate() {
        assertEquals(5, (int)b.pop());
        assertEquals(4, (int)b.pop());
        assertEquals(3, (int)b.pop());
        assertEquals(2, (int)b.pop());
        assertEquals(1, (int)b.pop());
    }

    @Test
    public void test() {
        Towers towers = new Towers();
        towers.moveDisks(N, a, b, c);
        validate();
    }

    @Test
    public void testIterative() {
        TowersIterative towers = new TowersIterative();
        towers.moveDisks(N, a, b, c);
        validate();
    }
}
