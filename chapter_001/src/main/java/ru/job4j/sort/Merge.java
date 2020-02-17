package ru.job4j.sort;

import java.util.Arrays;

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;
        while (resultPointer < rsl.length) {
            if (leftPointer == left.length) {
                rsl[resultPointer] = right[rightPointer];
                rightPointer++;
            } else if (rightPointer == right.length) {
                rsl[resultPointer] = left[leftPointer];
                leftPointer++;
            } else if (left[leftPointer] < right[rightPointer]) {
                rsl[resultPointer] = left[leftPointer];
                leftPointer++;
            } else {
                rsl[resultPointer] = right[rightPointer];
                rightPointer++;
            }
            resultPointer++;
        }
        return rsl;
    }
}