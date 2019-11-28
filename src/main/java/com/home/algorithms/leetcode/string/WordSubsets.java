package com.home.algorithms.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    /*
    We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a.

Return a list of all universal words in A.  You can return the words in any order.
     */

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList();
        for (int i = 0; i < A.length; i++) {
            if (isUniversal(A[i], B)) {
                res.add(A[i]);
            }
        }
        return res;
    }

    private boolean isUniversal(String word, String[] B) {
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length(); j++) {
                if (!word.contains("" + B[i].charAt(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
