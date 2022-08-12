package com.home.algorithms.leetcode.array;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int size = height.length;
        int[] leftMax = new int[size];
        leftMax[0] = height[0];
        int[] rightMax = new int[size];
        rightMax[size - 1] = height[size - 1];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < size; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
}
