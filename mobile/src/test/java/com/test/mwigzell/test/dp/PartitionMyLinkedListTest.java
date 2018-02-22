package com.test.mwigzell.test.dp;

import com.test.mwigzell.dp.PartitionLinkedList;
import com.test.mwigzell.vogella.ListNode;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by mwigzell on 2/4/18.
 */

public class PartitionMyLinkedListTest {
    @Test
    public void testPartition() {
        PartitionLinkedList sut = new PartitionLinkedList();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(5);
        list.add(10);
        list.add(2);
        list.add(1);
        sut.partition(list, 5);

        list.forEach(i -> System.out.print(i + " "));
    }

    ListNode appendEntry(ListNode head, int entry) {
        head.next = new ListNode<>();
        head.next.entry = entry;
        return head.next;
    }

    @Test
    public void testPartition2() {
        PartitionLinkedList sut = new PartitionLinkedList();
        ListNode<Integer> head = new ListNode<>();
        head.entry = 3;
        ListNode<Integer> last = appendEntry(head, 5);
        last = appendEntry(last, 8);
        last = appendEntry(last, 5);
        last = appendEntry(last, 10);
        last = appendEntry(last, 2);
        last = appendEntry(last, 1);

        head = sut.partition2(head, 5);
        do {
            System.out.print(head.entry + " ");
            head = head.next;
        } while(head != null);
    }
}
