package com.home.algorithms.leetcode.array;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height==null || height.length==0) {
            return 0;
        }
        int length = height.length;
        int xDistance = length-1;
        int left = 0;
        int right = length-1;
        int maxArea = 0;
        while (left<right) {
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight*xDistance--);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

}
