package com.test.mwigzell.cracking;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by mark on 11/20/16.
 */

public class KthToLast {
    public LinkListNode<Integer> kthToLast(LinkListNode<Integer> head, int k) {
        LinkListNode<Integer> node = head;
        Stack<LinkListNode> stack = new Stack<>();
        while(node != null) {
            stack.push(node);
            node = node.next;
        }
        LinkListNode<Integer> result = null;
        while(k-- >= 0) {
            result = stack.pop();
        }
        return result;
    }
}
