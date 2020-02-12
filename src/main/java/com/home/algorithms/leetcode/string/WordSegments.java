package com.home.algorithms.leetcode.string;

import java.util.List;

public class WordSegments {

    boolean wordBreak(String s, List<String> wordDict) {
        if (s==null || wordDict==null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        for (String word : wordDict) {
            if (s.contains(word)) {
                int start = s.indexOf(word);
                int end = word.length() + start;
                String leftPart = s.substring(0, start);
                String rightPart = s.substring(end);
                if (wordBreak(leftPart, wordDict) && wordBreak(rightPart, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean booleanArray(String s, List<String> wordDict) {
        if (s==null || wordDict==null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        boolean[] b = new boolean[s.length()+1];
        b[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(b[j] && wordDict.contains(s.substring(j,i))){
                    b[i] = true;
                    break;
                }

            }
        }
        return b[s.length()];
    }
}
