package com.test.mwigzell.top10;

/**
 * Created by mark on 11/5/16.
 */

public class Heapsort {
    int[] numbers;

    void exchange(int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    void heapify(int i, int n) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && numbers[left] > numbers[largest] ) {
            largest = left;
        }
        if (right < n && numbers[right] > numbers[largest]) {
            largest = right;
        }
        if (i != largest) {
            exchange(i, largest);
            heapify(largest, n);
        }
    }

    public void sort(int[] numbers) {
        this.numbers = numbers;
        int n = numbers.length;

        // first create heap of whole array
        for (int i = n/2-1; i >= 0; i--) {
            heapify(i, n);
        }

        // iteratively pull out largest value from heap and store at end of heap, decreasing size of heap until zero
        for (int s = n - 1; s >= 0; s--) {
            exchange(0, s);
            heapify(0, s);
        }
    }
}
