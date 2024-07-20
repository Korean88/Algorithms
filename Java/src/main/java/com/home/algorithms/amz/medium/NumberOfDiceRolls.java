package com.home.algorithms.amz.medium;

import java.util.HashMap;
import java.util.Map;

public class NumberOfDiceRolls {

    private static final int MOD = (int) Math.pow(10, 9) + 7;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] memo = new int[n + 1][target + 1];
        // Intialize the base case
/*        memo[n][target] = 1;
        for (int diceIndex = n - 1; diceIndex >= 0; diceIndex--) {
            for (int currSum = 0; currSum <= target; currSum++) {
                int ways = 0;
                // Iterate over the possible face value for current dice
                for (int i = 1; i <= Math.min(k, target - currSum); i++) {
                    ways = (ways + memo[diceIndex + 1][currSum + i]) % MOD;
                }
                memo[diceIndex][currSum] = ways;
            }
        }
        return memo[0][0];*/

        int res = topDown(n, target, k, new HashMap<>());
        return res;

    }

    private int topDown(int currentDie, int remainderOfTarget, int k, Map<CacheKey, Integer> cache) {
        if (currentDie == 0) {
            return remainderOfTarget == 0 ? 1 : 0;
        }
        CacheKey cacheKey = new CacheKey(currentDie, remainderOfTarget);
        if (cache.get(cacheKey) != null) {
            return cache.get(cacheKey);
        }
        int res = 0;
        for (int i = 1; i <= k; i++) {
            res += topDown(currentDie - 1, remainderOfTarget - i, k, cache);
        }
        cache.put(cacheKey, res);
        return res;
    }

    private static class CacheKey {
        int currentDie;
        int remainderOfTarget;
        CacheKey(int currentDie, int remainderOfTarget) {
            this.currentDie = currentDie;
            this.remainderOfTarget = remainderOfTarget;
        }
    }
}
