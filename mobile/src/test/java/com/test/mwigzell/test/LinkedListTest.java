package com.test.mwigzell.test;

import com.test.mwigzell.LinkedList;

import org.junit.Test;

import java.util.Iterator;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by mark on 11/16/16.
 */

public class LinkedListTest {
    @Test
    public void test() {
        LinkedList<String> list = new LinkedList<>();
        list.add("hello");
        list.add("mark");

        assertEquals("hello", list.get(0));
        assertEquals("mark", list.get(1));
        assertEquals(2, list.size());

        list.remove(0);
        assertEquals(1, list.size());
        assertEquals("mark", list.get(0));
    }

    @Test
    public void testIterator() {
        LinkedList<String> list = new LinkedList<>();
        list.add("hello");
        list.add("mark");

        Iterator<String> it = list.getIterator();
        assertTrue(it.hasNext());
        assertEquals("hello", it.next());
        assertEquals("mark", it.next());
        it.remove();
        assertTrue(it.hasNext());
        assertEquals("hello", it.next());
    }
}
