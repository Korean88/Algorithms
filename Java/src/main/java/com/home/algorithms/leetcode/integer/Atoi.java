package com.home.algorithms.leetcode.integer;

public class Atoi {

    public int myAtoi (String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        String trim = s.trim();
        int sign = 1;
        int currentPosition = 0;
        if (trim.charAt(0) == '-') {
            sign = -1;
            currentPosition = 1;
        } else if (trim.charAt(0) == '+') {
            currentPosition = 1;
        }

        if (currentPosition == 1 && trim.length() == 1) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = trim.toCharArray();
        int res = 0;
        boolean firstSymbol = true;
        while (currentPosition < chars.length && chars[currentPosition] >= '0' && chars[currentPosition] <= '9') {
            if (firstSymbol && chars[currentPosition] == '0') {
                currentPosition++;
            } else {
                sb.append(chars[currentPosition++]);
                firstSymbol = false;
            }
        }
        if (sb.length() > 0) {
            int maxLength = Integer.toString(Integer.MIN_VALUE).length();
            String resString;
            if (sb.length() > maxLength) {
                resString = sb.substring(0, maxLength);
            } else {
                resString = sb.toString();
            }
            long longValue = Long.parseLong(resString) * sign;
            if (longValue < Integer.MIN_VALUE) {
                res = Integer.MIN_VALUE;
            } else if (longValue > Integer.MAX_VALUE) {
                res = Integer.MAX_VALUE;
            } else {
                res = (int) longValue;
            }
        }
        return res;
    }
}
