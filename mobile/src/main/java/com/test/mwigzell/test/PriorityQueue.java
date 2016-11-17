package com.test.mwigzell.test;

import java.util.ArrayList;

/**
 * Created by mark on 11/15/16.
 */

public class PriorityQueue<T extends Comparable<T>> {
    ArrayList<T> q = new ArrayList<>();

    void swap(int a, int b) {
        T tmp = q.get(a);
        q.set(a, q.get(b));
        q.set(b, tmp);
    }

    void heapify(int n) {
        int largest = n;
        int left = 2 * n + 1;
        int right = 2 * n + 2;

        if ((left < q.size()) && (q.get(left).compareTo(q.get(largest)) > 0)) {
            largest = left;
        }
        if(right < q.size() && (q.get(largest).compareTo(q.get(right)) < 0)) {
            largest = right;
        }

        if (n != largest) {
            swap(n, largest);
            heapify(largest);
        }
    }

    void siftUp(int n) {
        int parent = n/2;

        if ((parent >= 0 ) && (q.get(parent).compareTo(q.get(n)) < 0)) {
            swap(n, parent);
            siftUp(parent);
        }
    }

    public void add(T item) {
        q.add(item);
        int n = q.size() -1;
        siftUp(n);
    }

    public T getNext() {
        T val = null;
        if (q.size() > 0) {
            val = q.get(0);
            if (q.size() > 1) {
                q.set(0, q.remove(q.size() - 1));
                heapify(0);
            }
        }
        return val;
    }
}
