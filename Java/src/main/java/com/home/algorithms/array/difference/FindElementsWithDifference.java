package com.home.algorithms.array.difference;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class FindElementsWithDifference {

    Set<Pair<Integer, Integer>> findWithSorting(int[] array, int difference) {
        Set<Pair<Integer, Integer>> res = new HashSet<>();
        if (array == null || array.length < 2) {
            return res;
        }
        Arrays.sort(array);
        for (int i=0; i<array.length-1; i++) {
            int j=i;
            while (++j<array.length && array[j]-array[i]<=difference) {
                if (array[j]-array[i]==difference) {
                    res.add(createPairSorted(array[i], array[j]));
                    break;
                }
            }
        }
        return res;
    }

    public Set<Pair<Integer, Integer>> findPairWithDifferenceLinear(int[] array, int difference) {
        Set<Pair<Integer, Integer>> res = new HashSet<>();
        if (array == null || array.length == 0) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (difference == 0 && map.get(i) > 1) {
                res.add(Pair.of(i, i));
            }
        }
        if (difference != 0) {
            Set<Integer> integers = map.keySet();
            for (int i : integers) {
                if (integers.contains(i + difference)) {
                    res.add(createPairSorted(i, i + difference));
                }
            }
        }
        return res;
    }

    private Pair<Integer, Integer> createPairSorted(int i, int j) {
        Pair<Integer, Integer> pair;
        if (i < j) {
            pair = Pair.of(i, j);
        } else {
            pair = Pair.of(j, i);
        }
        return pair;
    }

}
