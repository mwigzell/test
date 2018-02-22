package com.test.mwigzell.test.test;

import com.test.mwigzell.test.MyLinkedList;

import org.junit.Test;

import java.util.Iterator;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by mark on 11/16/16.
 */

public class MyLinkedListTest {
    @Test
    public void test() {
        MyLinkedList<String> list = new MyLinkedList<>();
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
        MyLinkedList<String> list = new MyLinkedList<>();
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
        MyLinkedList<String> list = new MyLinkedList<>();
        String val = list.remove(0);

        assertNull(val);
        assertTrue(list.size() == 0);
    }
}
