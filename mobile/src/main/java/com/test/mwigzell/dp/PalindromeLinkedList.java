package com.test.mwigzell.dp;

import com.test.mwigzell.vogella.ListNode;

/**
 * Created by mwigzell on 2/4/18.
 */

public class PalindromeLinkedList {
    static ListNode<Integer> list;

    static boolean checkEnd(ListNode<Integer> node) {
        if (node.next != null) {
            if (!checkEnd(node.next)) {
                return false;
            }
        }
        boolean rc = list.entry == node.entry;
        list = list.next;
        return rc;
    }

    public static boolean isPalindrome(ListNode<Integer> head) {
        list = head;
        return checkEnd(list.next);
    }

    static ListNode<Integer> cutFront(ListNode<Integer> list, int delta) {
        while(delta > 0) {
            delta--;
            list = list.next;
        }
        return list;
    }

    public static boolean isIntersecting(ListNode<Integer> list1, ListNode<Integer> list2) {
        int len1 = 1, len2 = 1;
        ListNode end1, end2;
        for (end1 = list1; end1.next != null; len1++) {
            end1 = end1.next;
        }

        for (end2 = list2; end2.next != null; len2++) {
            end2 = end2.next;
        }

        // determine intersection node
        int delta = Math.abs(len1 - len2);
        if (len1 > len2) {
            list1 = cutFront(list1, delta);
        } else {
            list2 = cutFront(list2, delta);
        }
        // now list1 and list2 are same lengths: now just iterate down till intersection node is found.
        for (; list1.next != null && list2.next != null; list1 = list1.next, list2 = list2.next) {
            if (list1 == list2) {
                System.out.println("Intersection found at " + list1.entry + "\n");
                break;
            }
        }

        return (end1 == end2);
    }
}
