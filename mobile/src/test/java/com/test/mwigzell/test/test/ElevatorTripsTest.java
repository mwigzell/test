package com.test.mwigzell.test.test;

import org.junit.Test;

import com.test.mwigzell.test.ElevatorTrips;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mark on 11/17/16.
 */

public class ElevatorTripsTest {
    @Test
    public void test1() {
        int[] A = new int[]{40, 40, 100, 80, 20};
        int[] B = new int[]{3, 3, 2, 2, 3};
        ElevatorTrips elevatorTrips = new ElevatorTrips();
        int count = elevatorTrips.solution(A, B, 3, 5, 200);
        assertEquals(6, count);
    }

    @Test
    public void test2() {
        int[] A = new int[]{40, 40, 100, 80, 20};
        int[] B = new int[]{3, 3, 2, 2, 3};
        ElevatorTrips elevatorTrips = new ElevatorTrips();
        int count = elevatorTrips.solution(A, B, 3, 5, 39);
        assertEquals(0, count);
    }

    @Test
    public void test3() {
        int[] A = new int[]{40, 40, 100, 80, 20};
        int[] B = new int[]{3, 3, 2, 2, 3};
        ElevatorTrips elevatorTrips = new ElevatorTrips();
        int count = elevatorTrips.solution(A, B, 3, 5, 99);
        assertEquals(2, count);
    }
}
