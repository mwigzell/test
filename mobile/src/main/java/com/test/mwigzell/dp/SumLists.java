package com.test.mwigzell.dp;

import com.test.mwigzell.vogella.ListNode;

/**
 * Created by mwigzell on 2/4/18.
 */

public class SumLists {
    static int convert(ListNode<Integer> list) {
        int a = 0;
        int column = 1;
        for(; list != null; list = list.next, column *= 10) {
            a += list.entry * column;
        }
        return a;
    }

    static ListNode appendEntry(ListNode list, int entry) {
        ListNode<Integer> node = new ListNode<>();
        node.next = list;
        node.entry = entry;
        return node;
    }

    public static ListNode<Integer> sumlists(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> sum = null;

        int z = convert(a) + convert(b);
        for (; z > 1; z /= 10) {
            sum = appendEntry(sum, z % 10);
        }

        return sum;
    }
}
