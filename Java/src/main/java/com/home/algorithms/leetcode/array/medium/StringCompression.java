package com.home.algorithms.leetcode.array.medium;

public class StringCompression {

    public int compress(char[] chars) {
        if (chars == null) {
            return 0;
        }
        if (chars.length < 2) {
            return chars.length;
        }
        int res = 0;
        for (int i = 0; i < chars.length;) {
            int currentCount = 0;
            char first = chars[i];
            while (i < chars.length && chars[i] == first) {
                currentCount++;
                i++;
            }
            chars[res++] = first;
            if (currentCount > 1) {
                for (char c : Integer.toString(currentCount).toCharArray()) {
                    chars[res++] = c;
                }
            }
        }
        for (int i = res; i < chars.length; i++) {
            chars[i] = '_';
        }
        return res;
    }
}
