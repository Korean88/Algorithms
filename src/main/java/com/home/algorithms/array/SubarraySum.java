package com.home.algorithms.array;

public class SubarraySum {

    int calculateMaxSubarraySum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        if (array.length == 1) {
            return array[0];
        }

        int p1 = 0, p2 = 0;
        int maxSum = Integer.MIN_VALUE;
        while (p2 < array.length) {
            int currentSum = sumUp(array, p1, p2);
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum >= maxSum) {
                p2++;
            } else {
                p1++;
                if (p1!=p2) {
                    p2--;
                }
                if (p1 > p2) {
                    p2=p1;
                }
            }
        }
        return maxSum;
    }

    private int sumUp(int[] array, int start, int end) {
        int res = 0;
        for (int i=start; i<=end; i++) {
            res+=array[i];
        }
        return res;
    }
}
