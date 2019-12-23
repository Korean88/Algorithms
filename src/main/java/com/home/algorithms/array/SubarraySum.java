package com.home.algorithms.array;

public class SubarraySum {

    int bruteForce(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                max = Math.max(max, sumUp(array, i, j));
            }
        }
        return max;
    }

    private int sumUp(int[] array, int start, int end) {
        int res = 0;
        for (int i=start; i<=end; i++) {
            res+=array[i];
        }
        return res;
    }

    int calculateMaxSubarraySum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        if (array.length == 1) {
            return array[0];
        }

        int maxSum = array[0];
        int currentMax = array[0];
        for (int i =1; i < array.length; i++) {
            currentMax = Math.max(array[i]+currentMax, array[i]);
            maxSum = Math.max(maxSum, currentMax);
        }
        return maxSum;
    }
}
