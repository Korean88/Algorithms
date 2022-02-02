package com.home.algorithms.leetcode.array;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums==null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        Set<List<Integer>> resSet = new HashSet<>();
        for (int i=0; i<nums.length-2; i++) {
            if (nums[i] > 0) break;
            Queue<Integer> twoSum = findTwoSum(nums, i);
            while (!twoSum.isEmpty()) {
                List<Integer> threeSums = new ArrayList<>();
                threeSums.add(nums[i]);
                threeSums.add(twoSum.poll());
                threeSums.add(twoSum.poll());
                resSet.add(threeSums);
            }
        }
        return new ArrayList<> (resSet);
    }

    private Queue<Integer> findTwoSum(int[] nums, int i) {
        int j = i+1;
        int k = nums.length-1;
        Queue<Integer> res = new LinkedList<>();
        while (j<k) {
            int sum = nums[i]+nums[j]+nums[k];
            if (sum < 0) {
                j++;
            } else if (sum > 0) {
                k--;
            } else {
                res.add(nums[j]);
                res.add(nums[k]);
                j++;
                k--;
            }
        }
        return res;
    }
}
