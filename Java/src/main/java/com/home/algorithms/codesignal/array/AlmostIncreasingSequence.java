package com.home.algorithms.codesignal.array;

public class AlmostIncreasingSequence {

    boolean solution(int[] array) {
        int length = array.length;
        int count = 0;
        if (length < 3) {
            return true;
        }
        for (int i = 0; i < length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        count = 0;
        for (int i = 0; i < length - 2; i++) {
            if (array[i] >= array[i + 2]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
