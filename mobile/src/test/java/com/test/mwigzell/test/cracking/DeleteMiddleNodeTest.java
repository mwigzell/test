package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.DeleteMiddleNode;
import com.test.mwigzell.cracking.LinkListNode;

import org.junit.Test;

/**
 * Created by mark on 11/20/16.
 */

public class DeleteMiddleNodeTest {
    @Test
    public void test() {
        DeleteMiddleNode dmn = new DeleteMiddleNode();
        LinkListNode<Character> list = new LinkListNode<>('a');
        LinkListNode<Character> next = new LinkListNode<>('b');
        list.next = next;
        next.next = new LinkListNode<>('c');
        next = next.next;
        next.next = new LinkListNode<>('d');
        next = next.next;
        next.next = new LinkListNode<>('e');
        dmn.deleteMiddleNode(list);
        for (next = list; next != null; next = next.next) {
            System.out.print(next.data);
            if (next.next != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }
}
