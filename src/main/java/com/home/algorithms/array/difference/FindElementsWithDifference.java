package com.home.algorithms.array.difference;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.Set;

public class FindElementsWithDifference {

    public Set<Pair<Integer, Integer>> findPairWithDifferenceBruteForce(int[] array, int difference) {
        Set<Pair<Integer, Integer>> res = new HashSet<>();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] - array[j] == difference || array[j] - array[i] == difference) {
                    res.add(Pair.of(array[i], array[j]));
                }
            }
        }
        return res;
    }
}
