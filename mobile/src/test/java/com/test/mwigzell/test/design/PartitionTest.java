package com.test.mwigzell.test.design;

import com.test.mwigzell.design.Partition;

import org.junit.Test;

/**
 * Created by mark on 2/25/18.
 */

public class PartitionTest {

    @Test
    public void test1() {
        Partition p = new Partition();
        int s[] = {100, 200, 300, 400, 500, 600, 700, 800, 900};
        p.partition(s, s.length - 1, 3);
    }
}
