package com.home.algorithms.amz.easy;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var map = new HashMap<Integer, Integer>();
        var stack = new Stack<Integer>();
        for (int i = nums2.length - 1; i >=0; i--) {
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
                stack.add(nums2[i]);
            } else {
                if (nums2[i] < stack.peek()) {
                    map.put(nums2[i], stack.peek());
                    stack.add(nums2[i]);
                } else {
                    stack.pop();
                    map.put(nums2[i], -1);
                }
            }
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
