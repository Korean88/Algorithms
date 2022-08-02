package com.home.algorithms.leetcode.array;

import java.util.Stack;

public class NextIntegerPermutation {

    public void nextPermutation(int[] nums) {
        int length = nums.length - 1;
        int i = length;
        while (i > 0 && nums[i] < nums[i - 1]) {
            i--;
        }
        if (i == 0) {
            reverse(nums, 0, length);
        } else {
            for (int j = length; j >= i; j--) {
                if (nums[j] > nums[i-1]) {
                    swap(nums, i-1, j);
                    reverse(nums, i, length);
                    break;
                }
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int buffer = nums[a];
        nums[a] = nums[b];
        nums[b] = buffer;
    }

    private void reverse(int[] nums, int start, int end) {
        Stack<Integer> buffer = new Stack<>();
        for (int i = start; i <= end; i++) {
            buffer.add(nums[i]);
        }
        while (start <= end) {
            nums[start++] = buffer.pop();
        }
    }
}
