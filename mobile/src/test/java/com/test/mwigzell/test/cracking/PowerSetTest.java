package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.PowerSet;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by mark on 11/18/16.
 */

public class PowerSetTest {
    @Test
    public void test() {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);

        PowerSet<Integer> powerSet = new PowerSet<>();
        ArrayList<ArrayList<Integer>> result = powerSet.run(set, 0);

        for (ArrayList<Integer> subset : result) {
            for (Integer i : subset) {
                System.out.print(String.format("%d ", i));
            }
            System.out.println();
        }
    }
}
