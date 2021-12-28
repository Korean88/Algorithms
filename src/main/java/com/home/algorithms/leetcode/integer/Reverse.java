package com.home.algorithms.leetcode.integer;

public class Reverse {

    public int reverse(int x) {
        int sign;
        if (x < 0) {
            sign = -1;
            x = -1 * x;
        } else {
            sign = 1;
        }

        long res = 0;
        while (x % 10 > 0 || x / 10 > 0) {
            int remainder = x % 10;
            x = x / 10;
            res = (res + remainder) * 10;
        }
        res = res / 10 * sign;
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) res;
    }

}
