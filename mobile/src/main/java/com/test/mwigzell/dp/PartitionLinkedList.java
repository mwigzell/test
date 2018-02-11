package com.test.mwigzell.dp;

import com.test.mwigzell.top10.Node;
import com.test.mwigzell.vogella.ListNode;

import java.util.LinkedList;

/**
 * Created by mwigzell on 2/4/18.
 */

public class PartitionLinkedList {

    public void partition(LinkedList<Integer> head, int partition) {
        int swap = 1;
        for (int i = 0; i < head.size(); i++) {
            if (head.get(i) >= partition) {
                if (swap <= i) {
                    swap = i + 1;
                    if (swap >= head.size()) {
                        break;
                    }
                }
                for(; swap < head.size(); swap++) {
                    int tmp = head.get(swap);
                    if (tmp < partition) {
                        head.set(swap, head.get(i));
                        head.set(i, tmp);
                        break;
                    }
                }
            }
        }
    }

    ListNode appendEntry(ListNode list, int entry) {
        ListNode<Integer> node = new ListNode<>();
        node.next = list;
        node.entry = entry;
        return node;
    }

    public ListNode<Integer> partition2(ListNode<Integer> head, int partition) {
        ListNode<Integer> below = null;
        ListNode<Integer> above = null;
        ListNode<Integer> node = head;
        for(; node != null; node = node.next) {
            if (node.entry < partition) {
                below = appendEntry(below, node.entry);
            } else {
                above = appendEntry(above, node.entry);
            }
        }
        ListNode<Integer> endOfBelow = below;
        while(endOfBelow.next != null) {
            endOfBelow = endOfBelow.next;
        }
        endOfBelow.next = above;
        return below;
    }
}
