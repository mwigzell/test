package com.test.mwigzell.vogella;

import com.test.mwigzell.LinkedList2;

/**
 * Created by mwigzell on 2/4/18.
 */

public class ListNode<E> {
    public E entry;
    public ListNode<E> next;

    public ListNode() {

    }

    public ListNode(E entry) {
        this.entry = entry;
    }
}
