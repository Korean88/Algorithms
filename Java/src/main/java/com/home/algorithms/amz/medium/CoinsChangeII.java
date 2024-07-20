package com.home.algorithms.amz.medium;

public class CoinsChangeII {

    public int change(int amount, int[] coins) {
        int[] combinations = new int[amount + 1];
        combinations[0] = 1;
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                combinations[i] += combinations[i - c];
            }
        }
        return combinations[amount];
    }
}
