package com.home.algorithms.leetcode.array.medium;

public class StringCompression {

    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }
        int modIndex = 0;
        int count = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                if (count > 1) {
                    modIndex = modifyArray(chars, modIndex, count, chars[i]);
                } else {
                    chars[modIndex++] = chars[i];
                }
                count = 1;
            }
        }
        if (chars[chars.length - 2] != chars[chars.length - 1]) {
            chars[modIndex++] = chars[chars.length - 1];
        } else {
            modIndex = modifyArray(chars, modIndex, count, chars[chars.length - 1]);
        }
        int res = modIndex;
        while (modIndex < chars.length) {
            chars[modIndex++] = '_';
        }
        return res;
    }

    private int modifyArray(char[] chars, int modIndex, int count, char substitute) {
        char[] digitsInCount = ("" + count).toCharArray();
        chars[modIndex++] = substitute;
        for (char c : digitsInCount) {
            chars[modIndex++] = c;
        }
        return modIndex;
    }

}
