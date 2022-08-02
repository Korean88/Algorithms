package com.home.algorithms.string;

public class PolindromeChecker {

    public boolean isPolindrome(String string) {
        if (string != null && string.length() != 0) {
            int left = 0;
            int right = string.length() - 1;
            if (left == right) return true;
            while (left < right) {
                if (string.charAt(left++) != string.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
