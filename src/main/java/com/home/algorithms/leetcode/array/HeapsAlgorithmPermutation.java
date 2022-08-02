package com.home.algorithms.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class HeapsAlgorithmPermutation {

    public List<int[]> recursion(int[] input) {
        int k = input.length;
        List<int[]> list = new ArrayList<>();
        return recurse(list, k, input);
    }

    private List<int[]> recurse(List<int[]> list, int k, int[] array) {
        if (k == 1) {
            list.add(array.clone());
            return list;
        }
        recurse(list, k - 1, array);
        for (int i = 0; i < k - 1; i++) {
            if (i < k - 1) {
                if (k % 2 == 0) {
                    swap(i, k - 1, array);
                } else {
                    swap(0, k - 1, array);
                }
            }
        }
        return list;
    }

    private void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public List<int[]> iterative(int[] input) {
        int n = input.length;
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = 0;
        }
        List<int[]> res = new ArrayList<>();
        res.add(input.clone());

        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(i % 2 == 0 ? 0 : indexes[i], i, input);
                res.add(input.clone());
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }
        return res;
    }
}