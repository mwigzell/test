package com.test.mwigzell.test.dp;

import com.test.mwigzell.dp.SumLists;
import com.test.mwigzell.vogella.ListNode;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by mwigzell on 2/4/18.
 */

public class SumListsTest {
    ListNode appendEntry(ListNode list, int entry) {
        ListNode<Integer> node = new ListNode<>();
        node.next = list;
        node.entry = entry;
        return node;
    }

    @Test
    public void sumLists() {
        ListNode<Integer> a, b;
        a = appendEntry(null, 6);
        a = appendEntry(a, 1);
        a = appendEntry(a, 7);

        b = appendEntry(null, 2);
        b = appendEntry(b, 9);
        b = appendEntry(b, 5);

        ListNode<Integer> sum = SumLists.sumlists(a, b);

        assertNotNull(sum);
        do {
            System.out.print(sum.entry + " ");
            sum = sum.next;
        } while(sum != null);

    }
}
