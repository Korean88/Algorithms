package com.home.algorithms.stairs;

import java.util.stream.IntStream;

public class ClimbingStairs {

    public int countRecursive(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return countRecursive(n - 2) + countRecursive(n - 1);
    }

    public int countLoop(int n) {
        if (n < 2) {
            return n;
        }
        int[] resArray = new int[n];
        resArray[0] = 1;
        resArray[1] = 2;
        for (int j = 2; j < n; j++) {
            resArray[j] = resArray[j - 1] + resArray[j - 2];
        }
        return resArray[n - 1];
    }

    public int countWithSupplier(int n) {
        if (n <= 2) {
            return n;
        }
        int[] state = {1, 2};
        return IntStream.generate(() -> {
            int res = state[0] + state[1];
            state[0] = state[1];
            state[1] = res;
            return res;
        })
                .limit(n - 2) //because the solutions for the first 2 steps are predefined
                .max()
                .orElse(0);
    }
}
