package com.home.algorithms.leetcode.string;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return null;
        }
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                prefix = findCommonPrefix(prefix, strs[i]);
            }
        }
        return prefix;
    }

    private String findCommonPrefix(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int lenght = Math.min(s1.length(), s2.length());
        for (int i = 0; i < lenght; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                sb.append(s1.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

}
