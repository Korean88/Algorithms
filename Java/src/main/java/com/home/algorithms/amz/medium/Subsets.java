package com.home.algorithms.amz.medium;

import java.util.*;

public class Subsets {

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        recurse(new ArrayList<>(), nums, 0, res);
//        return res;
//    }
//
//    public void recurse(List<Integer> currentSubset, int[] nums, int index, List<List<Integer>> res) {
//        if (index == nums.length) {
//            res.add(new ArrayList<>(currentSubset));
//            return;
//        }
//        currentSubset.add(nums[index]);
//        recurse(currentSubset, nums, index + 1, res);
//        currentSubset.remove(currentSubset.size() - 1);
//        recurse(currentSubset, nums, index + 1, res);
//    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }
            res.add(temp);
        }
        return res;
    }

}
