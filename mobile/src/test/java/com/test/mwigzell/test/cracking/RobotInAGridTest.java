package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.RobotInAGrid;
import com.test.mwigzell.cracking.TripleStep;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mark on 11/16/16.
 */

public class RobotInAGridTest {
    static final int MAX = 20;

    @Test
    public void test() {
        RobotInAGrid code = new RobotInAGrid();
        boolean[][] blocked = new boolean[MAX][MAX];
        blocked[1][0] = true;
        blocked[MAX-2][MAX - 1] = true;

        code.run(MAX, MAX, blocked);
        assertEquals(MAX - 1, code.finalRow());
        assertEquals(MAX - 1, code.finalCol());
    }
}
