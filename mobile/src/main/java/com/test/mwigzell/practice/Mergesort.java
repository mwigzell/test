package com.test.mwigzell.practice;

/**
 * Created by mark on 11/4/16.
 */

public class Mergesort {
    int[] numbers;
    int[] helper;

    void merge(int low, int middle, int high) {
        for (int i = 0; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int k = low;
        int i = low;
        int j = middle + 1;
        while (i <= middle && j <= high) {
            if (helper[i] < helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }

        for (; i <= middle; i++) {
            numbers[k++] = helper[i];
        }
    }

    void mergesort(int low, int high) {
        int middle = low + (high - low)/2;
        if (low < high) {
            mergesort(low, middle);
            mergesort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    public void sort(int[] numbers) {
        this.numbers = numbers;
        helper = new int[numbers.length];
        mergesort(0, numbers.length - 1);
    }
}
