package com.home.algorithms.goldmansachs.array;

public class CollectCoins {

    int maxCoins(char[][] table) {
        return findPath(table, 0, 0, true);
    }

    private int findPath(char[][] table, int i, int j, boolean rightDirection) {
        boolean fail = i >= table.length || j >= table[0].length ||
                i < 0 || j < 0 || table[i][j] == '#';
        if (!fail) {
            int currentWeight = 0;
            if (table[i][j] == 'c') {
                currentWeight = 1;
            }
            return Math.max(currentWeight + findPath(table, i, rightDirection ? j + 1 : j - 1, rightDirection),
                    currentWeight + findPath(table, i + 1, j, !rightDirection));
        }
        return 0;
    }

}
