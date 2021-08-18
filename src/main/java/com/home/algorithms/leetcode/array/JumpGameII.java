package com.home.algorithms.leetcode.array;

public class JumpGameII {

    public int jump(int[] nums) {
        int res = 0;
        if (nums != null && nums.length > 1) {
            res++;
            int startIndex = 0;
            int endIndex = nums[0];
            while (endIndex < nums.length - 1) {
                res++;
                startIndex = Math.min(nums.length - 1, findIndexOfMax(nums, startIndex + 1, endIndex));
                endIndex = startIndex + nums[startIndex];
            }
        }
        return res;
    }

    private int findIndexOfMax(int[] nums, int startIndex, int endIndex) {
        int max = 0;
        int res = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            if (i >= nums.length) {
                break;
            }
            int current = i + nums[i];
            if (current >= nums.length) {
                return i;
            }
            if (current >= max) {
                max = current;
                res = i;
            }
        }
        return res;
    }

    public int jump2(int[] nums) {
        int n = nums.length;
        int maxReach = 0;
        int maxJump = 0;
        int countJumps = 0;

        for (int i=0; i<n; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);

            if (maxReach == n-1) {
                return countJumps;
            }

            if (maxReach == i) {
                maxReach = maxJump;
                maxJump = 0;
                countJumps++;
            }
        }

        return countJumps;
    }
}
