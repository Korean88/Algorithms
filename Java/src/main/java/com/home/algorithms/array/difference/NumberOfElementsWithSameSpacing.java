package com.home.algorithms.array.difference;

public class NumberOfElementsWithSameSpacing {

    public int calculate(int[] array) {
        if (array == null) {
            return 0;
        }
        if (array.length < 3) {
            return array.length;
        }

        int max = 0;
        int currentDif = array[1] - array[0];
        int currentCount = 2;
        for (int i = 2; i < array.length; i++) {
            if (array[i] - array[i - 1] == currentDif) {
                currentCount++;
            } else {
                currentCount = 2;
                currentDif = array[i] - array[i - 1];
            }
            max = Math.max(max, currentCount);
        }
        return max;
    }
}
