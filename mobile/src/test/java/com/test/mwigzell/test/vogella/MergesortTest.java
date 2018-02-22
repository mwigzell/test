package com.test.mwigzell.test.vogella;

import com.test.mwigzell.vogella.Mergesort;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class MergesortTest {

    private int[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    private boolean checkSorted() {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testMergeSort() {
        long startTime = System.currentTimeMillis();

        Mergesort sorter = new Mergesort();
        sorter.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Mergesort " + elapsedTime);

        assertTrue(checkSorted());

    }

    @Test
    public void itWorksRepeatably() {
        for (int i = 0; i < 200; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for (int a = 0; a < numbers.length; a++) {
                numbers[a] = generator.nextInt(MAX);
            }
            Mergesort sorter = new Mergesort();
            sorter.sort(numbers);

            assertTrue(checkSorted());
        }
    }

    @Test
    public void partialSortedList() {
        numbers = new int[SIZE];
        int i = 0;
        numbers[i++] = 2;
        numbers[i++] = 1;
        numbers[i++] = 3;
        numbers[i++] = 4;
        numbers[i++] = 5;
        numbers[i++] = 6;
        numbers[i++] = 7;

        Mergesort sorter = new Mergesort();
        sorter.sort(numbers);

        assertTrue(checkSorted());
    }

    @Test
    public void testStandardSort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);


        assertTrue(checkSorted());
    }

    @Test
    public void practice() {
        for (int i = 0; i < 200; i++) {
            numbers = new int[SIZE];
            Random generator = new Random();
            for (int a = 0; a < numbers.length; a++) {
                numbers[a] = generator.nextInt(MAX);
            }
            com.test.mwigzell.practice.Mergesort sorter = new com.test.mwigzell.practice.Mergesort();
            sorter.sort(numbers);

            assertTrue(checkSorted());
        }
    }
}
