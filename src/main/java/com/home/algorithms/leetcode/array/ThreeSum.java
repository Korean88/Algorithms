package com.home.algorithms.leetcode.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<nums.length-2; i++) {
            List<Integer> found = findTwoSum(nums, i);
            if (!found.isEmpty()) {
                res.add(found);
            }
        }
        return res;
    }

    private List<Integer> findTwoSum(int[] nums, int i) {
        int j = i+1;
        int k = nums.length-1;
        int first = nums[i];
        List<Integer> res = new ArrayList<>();
        while (j<k) {
            int sum = first + nums[j] + nums[k];
            if (sum < 0) {
                j++;
            } else if (sum > 0) {
                k--;
            } else {
                return Arrays.asList(nums[i], nums[j], nums[k]);
            }
        }
        return res;
    }
}
