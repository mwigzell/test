package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.KthToLast;
import com.test.mwigzell.cracking.LinkListNode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by mark on 11/20/16.
 */

public class KthToLastTest {
    @Test
    public void test() {
        KthToLast kth = new KthToLast();
        LinkListNode<Integer> list = new LinkListNode<>(1);
        list.next = new LinkListNode<>(2);
        list.next.next = new LinkListNode<>(3);
        list.next.next.next = new LinkListNode<>(4);
        LinkListNode<Integer> result = kth.kthToLast(list, 1);
        assertNotNull(result);
        assertEquals(3, (int) result.data);
    }
}
