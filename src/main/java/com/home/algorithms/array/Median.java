package com.home.algorithms.array;

import java.util.stream.IntStream;

public class Median {

    double findMedian(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length + arr2.length < 2) {
            return Double.MIN_VALUE;
        }

        int[] concat = IntStream.concat(IntStream.of(arr1), IntStream.of(arr2))
                .sorted()
                .toArray();
        int length = concat.length;
        double res;
        if (length % 2 == 0) {
            res = ((double) (concat[length / 2 - 1] + concat[length / 2]) / 2);
        } else {
            res = concat[length / 2];
        }
        return res;
    }
}
