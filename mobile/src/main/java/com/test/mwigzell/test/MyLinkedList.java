package com.test.mwigzell.test;

import java.util.Iterator;

/**
 * Created by mark on 11/16/16.
 */

public class MyLinkedList<E> {
    class Node<E> {
        E entry;
        Node<E> next;

        public Node() {
            entry = null;
            next = null;
        }
        public Node(E entry) {
            this.entry = entry;
        }

        public E getEntry() { return entry; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> next) { this.next = next; }
    }

    Node<E> head;
    Node<E> last;
    int size = 0;

    public MyLinkedList() {
        head = new Node();
        last = head;
        head.setNext(last);
    }

    public void add(E entry) {
        last.next = new Node(entry);
        last = last.next;
        size++;
    }

    public int size() { return size; }

    Node<E> getNodeParent(int index) {
        Node<E> cur = head;
        for(int i = 0; i < size; i++) {
            if (i == index) {
                break;
            }
            cur = cur.getNext();
        }
        return cur;
    }

    public E get(int index) {
        E rc = null;
        Node<E> parent = getNodeParent(index);
        Node<E> item = parent.getNext();
        if (item != null) {
            rc = item.getEntry();
        }
        return rc;
    }

    public E remove(int index) {
        E rc = null;
        Node<E> parent = getNodeParent(index);
        Node<E> item = parent.getNext();
        if (size != 0 && item != null) {
            rc = item.getEntry();
            parent.setNext(item.getNext());
            size--;
        }
        return rc;
    }

    class LinkedListIterator<E> implements Iterator<E> {
        MyLinkedList<E> list;
        int i = -1;

        public LinkedListIterator(MyLinkedList<E> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return list.get(i + 1) != null;
        }

        @Override
        public E next() {
            return list.get(++i);
        }

        @Override
        public void remove() {
            if (i >= 0) {
                list.remove(i--);
                if (i >= 0) {
                    i--; // decrement to before the previous entry so that next() will work on previous entry
                }
            }
        }
    }

    public Iterator<E> getIterator() {
        return new LinkedListIterator<E>(this);
    }
}
