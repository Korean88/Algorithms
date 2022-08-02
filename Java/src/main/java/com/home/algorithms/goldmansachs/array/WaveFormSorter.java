package com.home.algorithms.goldmansachs.array;

import java.util.Arrays;

public class WaveFormSorter {

    int[] sortInWaveForm(int[] input) {
        if (input == null || input.length == 0) {
            return null;
        }

        Arrays.sort(input);
        int start = 0;
        int end = input.length - 1;
        int length = input.length;
        int[] res = new int[length];
        int i = 0;
        while (start < end) {
            res[i++] = input[start++];
            res[i++] = input[end--];
        }

        if (length % 2 > 0) {
            res[i] = input[length / 2];
        }
        return res;
    }
}
