package com.test.mwigzell.test.dp;

import com.test.mwigzell.dp.PalindromeLinkedList;
import com.test.mwigzell.vogella.ListNode;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by mwigzell on 2/4/18.
 */

public class PalindromeMyLinkedListTest {
    void printList(ListNode list) {
        while(list != null) {
            System.out.print(list.entry + " ");
            list = list.next;
        }
        System.out.print("\n");
    }

    ListNode appendEntry(ListNode list, int entry) {
        ListNode<Integer> node = new ListNode<>();
        node.next = list;
        node.entry = entry;
        return node;
    }

    @Test
    public void isPalindrome() {
        ListNode<Integer> list = null;
        list = appendEntry(list, 99);
        list = appendEntry(list, 1);
        list = appendEntry(list, 2);
        list = appendEntry(list, 3);
        list = appendEntry(list, 4);
        list = appendEntry(list, 3);
        list = appendEntry(list, 2);
        list = appendEntry(list, 1);
        list = appendEntry(list, 99);

        assertTrue(PalindromeLinkedList.isPalindrome(list));
    }

    void addLast(ListNode<Integer> head, ListNode<Integer> node) {
        ListNode<Integer> last = head;
       while(last.next != null) {
           last = last.next;
       }
       last.next = node;
    }

    @Test
    public void isIntersecting() {
        ListNode<Integer> list1 = new ListNode(1);
        addLast(list1, new ListNode(2));
        addLast(list1, new ListNode(3));
        ListNode<Integer> aNode = new ListNode(4);
        addLast(list1, aNode);
        addLast(list1, new ListNode(5));
        addLast(list1, new ListNode(6));

        ListNode<Integer> list2 = new ListNode(1);
        addLast(list2, aNode);

        System.out.print("List 1: ");
        printList(list1);

        System.out.print("List 2: ");
        printList(list2);

        assertTrue(PalindromeLinkedList.isIntersecting(list1, list2));
    }
}
