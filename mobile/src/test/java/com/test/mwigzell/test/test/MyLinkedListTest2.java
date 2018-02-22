package com.test.mwigzell.test.test;

import com.test.mwigzell.test.LinkedList2;

import org.junit.Test;

import java.util.Iterator;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by mark on 11/16/16.
 */

public class MyLinkedListTest2 {
    @Test
    public void test() {
        LinkedList2<String> list = new LinkedList2<>();
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
        LinkedList2<String> list = new LinkedList2<>();
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

    @Test
    public void testRemoveOnEmpty() {
        LinkedList2<String> list = new LinkedList2<>();
        String val = list.remove(0);

        assertNull(val);
        assertTrue(list.size() == 0);
    }

    @Test
    public void testRemoveAll() {
        LinkedList2<String> list = new LinkedList2<>();
        list.add("hello");
        list.add("mark");
        list.remove(0);
        list.remove(0);

        assertTrue(list.size() == 0);
    }
}
