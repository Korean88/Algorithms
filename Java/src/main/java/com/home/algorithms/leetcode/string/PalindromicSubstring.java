package com.home.algorithms.leetcode.string;

public class PalindromicSubstring {

    String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String longestSubstring = Character.toString(s.charAt(0));

        int length = s.length();
        int start;
        int end;
        for (double center = 0.5; center < length; center += 0.5) {
            if (center % 1 > 0) {
                start = (int) (center - 0.5);
                end = (int) (center + 0.5);
            } else {
                start = (int) center - 1;
                end = (int) center + 1;
            }
            while (start >= 0 && end < length && s.charAt(start) == s.charAt(end)) {
                String currentLongest = s.substring(start, end + 1);
                if (longestSubstring.length() < currentLongest.length()) {
                    longestSubstring = currentLongest;
                }
                start--;
                end++;
            }
        }
        return longestSubstring;
    }
}
