package com.home.algorithms.amz.medium;

import java.util.Arrays;

public class MinNumberOfKeypresses {

    public int minimumKeypresses(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int round = 1;
        int key = 0;
        int res = 0;
        for (int i = 25; i >= 0; i--) {
            key++;
            if (key > 9) {
                key = 1;
                round++;
            }
            res += freq[i] * round;
        }
        return res;
    }
}
