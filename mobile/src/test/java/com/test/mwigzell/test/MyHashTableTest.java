package com.test.mwigzell.test;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mark on 11/13/16.
 */

public class MyHashTableTest {
    @Test
    public void test() {
        MyHashTable<String, String> table = new MyHashTable<>(1);

        table.put("hallo", "world");
        table.put("mark", "wigzell");
        table.put("alma", "wigzell");
        table.put("hallo", "you");

        assertEquals("you", table.get("hallo"));
        assertEquals("wigzell", table.get("alma"));
    }
}
