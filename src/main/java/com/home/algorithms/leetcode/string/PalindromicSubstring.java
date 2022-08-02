package com.home.algorithms.leetcode.string;

public class PalindromicSubstring {

    String longestPalindrome(String s) {
        if (s==null || s.length()==0) {
            return "";
        }
        String longestSubstring = Character.toString(s.charAt(0));

        int length = s.length();
        for (double d = 0.5d; d< length; d+=0.5) {
            int start, end;
            if (d % 1 > 0) {
                start=(int)(d-0.5);
                end=(int)(d+0.5);
            } else {
                start = (int)d-1;
                end = (int)d+1;
            }
            while (start>=0 && end<length) {
                if (s.charAt(start)==s.charAt(end)) {
                    String currentLongest = s.substring(start, end + 1);
                    end++;
                    start--;
                    if (longestSubstring.length() < currentLongest.length()) {
                        longestSubstring=currentLongest;
                    }
                } else {
                    break;
                }
            }
        }
        return longestSubstring;
    }
}
