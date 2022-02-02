package com.home.algorithms.leetcode.array;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> resSet = new HashSet<>();
        for (int i=0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums [high];
                    if (sum < target) {
                        low++;
                    } else if (sum > target) {
                        high--;
                    } else {
                        resSet.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;
                    }
                }
            }
        }
        return new ArrayList<>(resSet);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.emptyList();
        }
        Set<List<Integer>> resSet = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int first = nums[i];
                int second = nums[j];
                int[] sortedReduced = reduceAndSort(nums, i, j);
                int target2 = target - first - second;
                List<List<Integer>> list = find4SumIfPossible(sortedReduced, target2);
                if (!list.isEmpty()) {
                    for (List<Integer> l : list) {
                        l.add(first);
                        l.add(second);
                        l.sort(Integer::compareTo);
                        resSet.add(l);
                    }
                }
            }
        }
        return new ArrayList<>(resSet);
    }

    private List<List<Integer>> find4SumIfPossible(int[] sortedReduced, int target2) {
        int i = 0;
        int j = sortedReduced.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (i < j) {
            int sum = sortedReduced[i] + sortedReduced[j];
            if (sum < target2) {
                i++;
            } else if (sum > target2) {
                j--;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(sortedReduced[i]);
                list.add(sortedReduced[j]);
                res.add(list);
                i++;
                j--;
            }
        }
        return res;
    }

    private int[] reduceAndSort(int[] nums, int i, int j) {
        int[] res = new int[nums.length - 2];
        int index = 0;
        for (int k = 0; k < nums.length; k++) {
            if (k != i && k != j) {
                res[index] = nums[k];
                index++;
            }
        }
        Arrays.sort(res);
        return res;
    }

}
