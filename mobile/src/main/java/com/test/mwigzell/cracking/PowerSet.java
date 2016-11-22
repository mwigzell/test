package com.test.mwigzell.cracking;

import java.util.ArrayList;

/**
 * Created by mark on 11/18/16.
 */

public class PowerSet<T> {

    ArrayList<T> subset(ArrayList<T> set, int m, int n) {
        ArrayList<T> s = new ArrayList<>();
        for (int i = m; i <=n; i++) {
            s.add(set.get(i));
        }
        return s;
    }

    public ArrayList<ArrayList<T>> run(ArrayList<T> set, int index) {
        ArrayList<ArrayList<T>> allSubSets = new ArrayList<>();
        if (index == set.size()) {
            ArrayList<T> empty = new ArrayList<T>();
            allSubSets.add(empty);
        } else {
            ArrayList<ArrayList<T>> moreSubSets = new ArrayList<ArrayList<T>>();
            ArrayList<ArrayList<T>> subSets = run(set, index + 1);
            moreSubSets.addAll(subSets);
            for (ArrayList<T> s : subSets) {
                ArrayList<T> newSubset = new ArrayList<T>();
                newSubset.addAll(s);
                newSubset.add(set.get(index));
                moreSubSets.add(newSubset);
            }
            allSubSets.addAll(moreSubSets);
        }
        return allSubSets;
    }
}
