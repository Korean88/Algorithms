package com.home.algorithms.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    /*
    We are given two arrays A and B of words.  Each word is a string of lowercase letters.

    Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.
    For example, "wrr" is a subset of "warrior", but is not a subset of "world".

    Now say a word a from A is universal if for every b in B, b is a subset of a.

    Return a list of all universal words in A.  You can return the words in any order.
     */

    //time complexity O(n^3)
    public List<String> bruteForceWordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (isUniversalBruteForce(A[i], B)) {
                res.add(A[i]);
            }
        }
        return res;
    }

    private boolean isUniversalBruteForce(String word, String[] B) {
        String originalWord = word;
        for (String s : B) {
            word = originalWord;
            for (int j = 0; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                if (!word.contains("" + currentChar)) {
                    return false;
                } else {
                    int endIndex = word.indexOf(currentChar);
                    String secondPart = word.indexOf(currentChar) == word.length() - 1 ? "" :
                            word.substring(word.indexOf(currentChar) + 1);
                    word = word.substring(0, endIndex) + secondPart;
                }
            }
        }
        return true;
    }

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] maxWordCnt = new int[26];
        List<String> list = new ArrayList<>();
        for (String b: B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; i++) {
                maxWordCnt[i] = Math.max(maxWordCnt[i], bCount[i]);
            }
        }

        for (String a: A) {
            int[] aCount = count(a);
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (aCount[i] < maxWordCnt[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) list.add(a);
        }
        return list;
    }

    private int[] count(String word) {
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }
        return arr;
    }

}
