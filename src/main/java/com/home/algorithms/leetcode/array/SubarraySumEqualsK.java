package com.home.algorithms.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int start = 0;
        int end = nums.length - 1;
        Map<Integer, Integer> rightSideSums = new HashMap<>();
        Map<Integer, Integer> leftSideSums = new HashMap<>();
        leftSideSums.put(end, calcSum(nums, start, end));
        for (int i = nums.length - 1; i >= 0; i--) {
            res += calcSumsInRangeFromLeft(nums, k, start, i - 1, leftSideSums);
            res += calcSumsInRangeFromRight(nums, k, i, end, rightSideSums);
        }
        return res;
    }

    private int calcSumsInRangeFromLeft(int[] nums, int k, int start, int end, Map<Integer, Integer> leftSideSums) {
        int resInRange = 0;
        Integer previousSum = leftSideSums.get(end + 1);
        int sum = previousSum - nums[end + 1];
        leftSideSums.put(end, sum);
        while (start <= end) {
            if (sum == k) {
                resInRange++;
            }
            sum = sum - nums[start];
            start++;
        }
        return resInRange;
    }

    private int calcSumsInRangeFromRight(int[] nums, int k, int start, int end, Map<Integer, Integer> rightSideSums) {
        int sum = rightSideSums.getOrDefault(start + 1, 0) + nums[start];
        rightSideSums.put(start, sum);
        if (sum == k) {
            return 1;
        }
        return 0;
    }

    private int calcSum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

}