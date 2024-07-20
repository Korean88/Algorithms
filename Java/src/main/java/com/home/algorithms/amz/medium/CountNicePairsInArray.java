package com.home.algorithms.amz.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInArray {
    private static final int MOD = (int) Math.pow(10, 9) + 7;

    public int countNicePairs(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int subtr = nums[i] - rev(nums[i]);
            int sameSum = map.getOrDefault(subtr, 0) + 1;
            map.put(subtr, sameSum);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > 0) {
                int sameSum = e.getValue();
                res += sameSum * (sameSum - 1) / 2;
            }
        }
        return res % MOD;
    }

    private int rev(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        return Integer.parseInt(sb.reverse().toString());
    }

}
