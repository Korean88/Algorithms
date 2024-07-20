package com.home.algorithms.amz.medium;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreak {

    boolean wordBreak(String s, List<String> wordDict) {
        boolean[] memo = new boolean[s.length()];
        Set<Integer> wordLengths = wordDict.stream()
                .map(String::length)
                .collect(Collectors.toSet());
        for (int start = 0; start < s.length(); start++) {
            for (int length : wordLengths) {
                int end = start + length;
                if (end <= s.length()) {
                    if ((start == 0 || memo[start - 1]) && wordDict.contains(s.substring(start, end))) {
                        memo[end - 1] = true;
                    }
                }
            }
        }
        return memo[s.length() - 1];
    }

}
