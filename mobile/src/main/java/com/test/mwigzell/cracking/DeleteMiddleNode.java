package com.test.mwigzell.cracking;

/**
 * Created by mark on 11/20/16.
 */

public class DeleteMiddleNode<T> {
    public void deleteMiddleNode(LinkListNode<T> head) {
        LinkListNode<T> node = head;
        LinkListNode<T> runner = node;
        while(node != null) {
            runner = runner.next;
            if (runner != null) {
                runner = runner.next;
            }

            if (runner != null && runner.next == null) {
                node.next = node.next.next;
                break;
            }

            node = node.next;
        }
    }
}
