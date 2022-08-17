package com.home.algorithms.leetcode.string.easy;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null || ransomNote.length() == 0 || magazine.length() == 0 || magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] dict = new int[26];
        int a = 'a';
        for (char c : magazine.toCharArray()) {
            dict[c - a]++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--dict[c - a] < 0) {
                return false;
            }
        }
        return true;
    }

}
