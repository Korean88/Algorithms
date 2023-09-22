package com.home.algorithms.codesignal.array;

public class StringRearrangement {

    boolean solution(String[] inputArray) {
        boolean[] used = new boolean[inputArray.length];
        return findSequence(inputArray, null, used, 0);
    }

    private boolean findSequence(String[] a, String prev, boolean[] used, int n) {
        if (n == a.length) {
            return true;
        }
        for (int i = 0; i < a.length; i++) {
            if (!used[i] && (prev == null || differByOne(prev, a[i]))) {
                used[i] = true;
                if (findSequence(a, a[i], used, n+1)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    private static boolean differByOne(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    public int[] productExceptSelf(int[] nums) {
        var totalProduct = 1;
        for (int num : nums) {
            totalProduct *= num;
        }
        int[] res = new int[nums.length];
        for (int i=0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res[i] = totalProduct / nums[i];
            }
        }
        return res;
    }

}
