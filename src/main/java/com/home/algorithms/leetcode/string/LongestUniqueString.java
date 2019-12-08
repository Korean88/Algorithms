package com.home.algorithms.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestUniqueString {

    int slidingWindowsOptimized(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            res = Math.max(res, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return res;
    }

    int slidingWindows(String s) {
        int length = s.length();
        Set<Character> characters = new HashSet<>();
        int i = 0, j = 0, res = 0;
        while (j < length) {
            if (!characters.contains(s.charAt(j))) {
                characters.add(s.charAt(j++));
                res = Math.max(res, j-i);
            } else {
                characters.remove(s.charAt(i++));
            }
        }
        return res;
    }
}
