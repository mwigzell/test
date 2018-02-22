package com.test.mwigzell.test.test;

import com.test.mwigzell.test.PriorityQueue;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mark on 11/15/16.
 */

public class PriorityQueueTest {

    @Test
    public void test() {
        PriorityQueue<Integer> q = new PriorityQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        assertEquals(4, q.getNext().intValue());
        assertEquals(3, q.getNext().intValue());
        assertEquals(2, q.getNext().intValue());
        assertEquals(1, q.getNext().intValue());
    }
}
