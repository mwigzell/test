package com.test.mwigzell.practice;

/**
 * Created by mark on 10/27/16.
 */

public class Quicksort {
    int[] numbers;

    public void sort(int[] values) {
        if (values == null || values.length <= 1) {
            return;
        }
        numbers = values;
        int low = 0;
        int high = values.length -1;

        quicksort(low, high);
    }

    void quicksort(int low, int high) {
        int i = low;
        int j = high;
        int pivot = numbers[low + (high - low)/2];

        while (i < j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = tmp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quicksort(low, j);
        }
        if (i < high) {
            quicksort(i, high);
        }
    }
}
