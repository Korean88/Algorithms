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
                int end = word.length() - 1 + start;
                String modified1 = s.substring(0, start);
                String modified2 = s.substring(end+1);
                if (wordBreak(modified1, wordDict) && wordBreak(modified2, wordDict)) {
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
