package com.home.algorithms.leetcode.integer;

public class DivideWithLimitations {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean negative = dividend < 0 ^ divisor < 0;
        int ans = 0;

        dividend = toNegative(dividend);
        divisor = toNegative(divisor);

        while (dividend <= divisor) {
            dividend -= divisor;
            ans++;
        }

        return negative ? -ans : ans;
    }

    private static int toNegative(int a) {
        return (a < 0) ? a : -a;
    }
}
