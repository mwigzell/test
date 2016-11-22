package com.test.mwigzell;


// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Arrays;

public class ElevatorTrips {
    int count;

    void visitFloors(boolean[] floor, int sumPeople) {
        if (sumPeople > 0) {
            for (int j = 0; j < floor.length; j++) {
                if (floor[j] == true) {
                    count++;
                }
                floor[j] = false;
            }
            count++; // return to floor 0
        }
    }

    boolean isFit(int A, int X, int Y, int sumPeople, int sumWeight) {
        return ((sumPeople + 1 <= X) && (sumWeight + A <= Y));
    }

    public int solution(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8
        count = 0;
        int sumPeople = 0;
        int sumWeight = 0;
        boolean[] floor = new boolean[M + 1];
        int max = A.length;
        for (int i = 0; i < max; i++) {
            if (!isFit(A[i], X, Y, sumPeople, sumWeight) ) {
                visitFloors(floor, sumPeople);

                // empty elevator
                sumPeople = 0;
                sumWeight = 0;
            }

            // now process the new person at i
            if (isFit(A[i], X, Y, sumPeople, sumWeight)) {
                floor[B[i]] = true;
                sumPeople++;
                sumWeight += A[i];
            } else if (sumPeople == 0) {
                break; // a person is too big to fit in the elevator
            }
        }

        // process final trip
        visitFloors(floor, sumPeople);

        return count;
    }
}