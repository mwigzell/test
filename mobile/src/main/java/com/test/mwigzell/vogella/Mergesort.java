package com.test.mwigzell.vogella;

/**
 * Created by mark on 11/4/16.
 */

public class Mergesort {
    int[] numbers;
    int[] helper;

      void merge(int low, int middle, int high) {
        for(int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        while(i <= middle && j <= high) {
            if (helper[i] < helper[j]) {
                numbers[k] = helper[i];
                i++;
                k++;
            } else {
                numbers[k] = helper[j];
                j++;
                k++;
            }
        }

        // copy rest of lower array
        while(i <= middle) {
            numbers[k] = helper[i];
            i++;
            k++;
        }
    }

    void mergesort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;

            mergesort(low, middle);
            mergesort(middle + 1, high);

            merge(low, middle, high);
        }
    }

    public void sort(int[] numbers) {
        this.numbers = numbers;
        helper = new int[numbers.length];

        mergesort(0, numbers.length-1);
    }
}
