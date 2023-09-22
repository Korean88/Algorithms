package com.home.algorithms.leetcode.array.medium;

import java.util.HashMap;
import java.util.List;

public class MaxSumAlmostUniqueSubarray {

    public long maxSum(List<Integer> nums, int m, int k) {
        var unique = new HashMap<Integer, Integer>();
        long currentSum = 0;
        for (int i = 0; i < k; i++) {
            Integer current = nums.get(i);
            unique.put(current, unique.getOrDefault(current, 0) + 1);
            currentSum += current;
        }
        long max = 0;
        if (unique.size() >= m) {
            max = currentSum;
        }
        var start = 1;
        var end = k + 1;
        while (end <= nums.size()) {
            Integer leftRemoved = nums.get(start - 1);
            Integer rightAdded = nums.get(end - 1);
            unique.put(leftRemoved, unique.get(leftRemoved) - 1);
            if (unique.get(leftRemoved) == 0) {
                unique.remove(leftRemoved);
            }
            unique.put(rightAdded, unique.getOrDefault(rightAdded, 0) + 1);
            currentSum = currentSum - leftRemoved + rightAdded;
            if (unique.size() >= m) {
                max = Math.max(currentSum, max);
            }
            start++;
            end++;
        }
        return max;
    }

}
