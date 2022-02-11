package com.home.algorithms.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class FindIndexesInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] res;
        if (nums != null && nums.length > 0) {
            Set<Integer> visitedState = new HashSet<>();
            res = find(nums, target, 0, nums.length - 1, visitedState);
        } else {
            res = new int[]{-1, -1};
        }
        return res;
    }

    private int[] find(int[] nums, int target, int start, int end, Set<Integer> visitedState) {
        int center = start + (end - start) / 2;
        if (!visitedState.contains(center)) {
            visitedState.add(center);
            if (nums[center] > target) {
                end = Math.max(0, center - 1);
                return find(nums, target, start, end, visitedState);
            } else if (nums[center] < target) {
                start = Math.min(center + 1, nums.length - 1);
                return find(nums, target, start, end, visitedState);
            } else if (nums[center] == target) {
                int a = center;
                int b = center;
                while (nums[a] == target && a != 0) {
                    a--;
                }
                if (nums[a] != target) {
                    a++;
                }
                while (nums[b] == target && b != nums.length - 1) {
                    b++;
                }
                if (nums[b] != target) {
                    b--;
                }
                return new int[]{a, b};
            }
        }
        return new int[]{-1, -1};
    }
}
