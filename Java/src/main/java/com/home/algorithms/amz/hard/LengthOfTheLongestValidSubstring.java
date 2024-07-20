package com.home.algorithms.amz.hard;

import java.util.HashSet;
import java.util.List;

public class LengthOfTheLongestValidSubstring {

    public int longestValidSubstring(String word, List<String> forbidden) {
        var forbiddenSet = new HashSet<>(forbidden);
        int res = 0;
        int right = word.length();
        for (int left = word.length() - 1; left >= 0; left--) {
            for (int k = left+1; k <= Math.min(right, left + 10); k++) {
                if (forbiddenSet.contains(word.substring(left, k))) {
                    right = k - 1;
                    break;
                }
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

}
