package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.LinkListNode;
import com.test.mwigzell.cracking.SumLists;

import org.junit.Test;

/**
 * Created by mark on 11/20/16.
 */

public class SumListsTest {
    void printList(LinkListNode<Integer> result) {
        for (LinkListNode<Integer> next = result; next != null; next = next.next) {
            System.out.print(next.data);
            if (next.next != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    @Test
    public void testReverse() {
        SumLists sumLists = new SumLists();
        LinkListNode<Integer> val1 = new LinkListNode<>(7);
        val1.next = new LinkListNode<>(1);
        val1.next.next = new LinkListNode<>(6);

        LinkListNode<Integer> val2 = new LinkListNode<>(5);
        val2.next = new LinkListNode<>(9);
        val2.next.next = new LinkListNode<>(2);

        LinkListNode<Integer> result = sumLists.sumReverse(val1, val2);
        printList(result);

    }

    @Test
    public void test() {
        SumLists sumLists = new SumLists();
        LinkListNode<Integer> val1 = new LinkListNode<>(6);
        val1.next = new LinkListNode<>(1);
        val1.next.next = new LinkListNode<>(7);

        LinkListNode<Integer> val2 = new LinkListNode<>(2);
        val2.next = new LinkListNode<>(9);
        val2.next.next = new LinkListNode<>(5);

        LinkListNode<Integer> result = sumLists.sum(val1, val2);
        printList(result);

    }
}
