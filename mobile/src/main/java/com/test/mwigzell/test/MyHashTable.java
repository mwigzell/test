package com.test.mwigzell.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mark on 11/13/16.
 */

public class MyHashTable<K, V> {
    class Tuple<K,V> {
        K key;
        V val;
        public Tuple(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    int NBUCKETS = 6;
    List<Tuple<K, V>> buckets[] = new LinkedList[NBUCKETS];

    public MyHashTable(int nbuckets) {
        NBUCKETS = nbuckets;
        for (int i = 0; i < NBUCKETS; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K k, V v) {
        int i = k.hashCode() % NBUCKETS;
        if (buckets[i].size() == 0) {
            buckets[i].add(new Tuple(k, v));
        } else {
            boolean found = false;
            for (Tuple t : buckets[i]) {
                if (t.key.equals(k)) {
                    t.val = v;
                    found = true;
                    break;
                }
            }
            if (!found) {
                buckets[i].add(new Tuple(k,v));
            }
        }
    }

    public V get(K key) {
        V rc = null;
        int i = key.hashCode() % NBUCKETS;
        int size = buckets[i].size();
        if (size == 1) {
            return buckets[i].get(0).val;
        } else if (size > 1) {
            for (Tuple t : buckets[i]) {
                if (t.key.equals(key)) {
                    rc = (V)t.val;
                    break;
                }
            }
        }
        return rc;
    }
}
