package com.home.algorithms.leetcode.integer;

public class DivideWithLimitations {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor == 1) {
                return dividend;
            }
        }
        boolean negative = dividend < 0 ^ divisor < 0;
        int res = 0;
        int timesDoubled = 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int currentDivisor = divisor;

        while (dividend >= divisor) {
            if (dividend >= currentDivisor) {
                dividend -= currentDivisor;
                res += timesDoubled;
                currentDivisor = currentDivisor << 1;
                timesDoubled = timesDoubled << 1;
            } else {
                currentDivisor = currentDivisor >> 1;
                timesDoubled = timesDoubled >> 1;
            }
        }
        return negative ? -res : res;
    }

}
