package com.home.algorithms.leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;

public class ScrambledPalindrome {

    public boolean isScrambledPalindrome(String input) {
        if (input == null || input.length() == 0) {
            return false;
        }
        int length = input.length();
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = input.toCharArray();
        for (int i = 0; i < length; i++) {
            map.compute(chars[i], (k,v) -> v == null ? 1 : v + 1);
        }
        boolean odd = length % 2 == 1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1 && odd) {
                odd = false;
            } else if (entry.getValue() % 2 == 1) {
                return false;
            }
        }
        return true;
    }


}
