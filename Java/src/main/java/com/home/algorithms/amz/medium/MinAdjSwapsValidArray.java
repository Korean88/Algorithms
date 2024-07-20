package com.home.algorithms.amz.medium;

public class MinAdjSwapsValidArray {

    public int minimumSwaps(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minValue) {
                minValue = nums[i];
                minIndex = i;
            }
            if (nums[i] >= maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        int res = 0;
        if (minIndex > maxIndex) {
            maxIndex++;
        }
        res = res + minIndex + (nums.length - 1 - maxIndex);
        return res;
    }

    private int swap(int[] nums, int i1, int i2, int indexChanged) {
        int buffer = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = buffer;
        if (i1 == indexChanged) {
            return i2;
        } else if (i2 == indexChanged) {
            return i1;
        } else {
            return indexChanged;
        }
    }

}
