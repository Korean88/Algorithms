package com.home.algorithms.amz.medium;

import java.util.*;

public class NumberOfRectanglesContainingEachPoint {

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        var map = new HashMap<Integer, List<Integer>>();
        for (int[] r : rectangles) {
            var lengths = map.getOrDefault(r[1], new ArrayList<>());
            lengths.add(r[0]);
            map.put(r[1], lengths);
        }
        for (var lengths : map.values()) {
            Collections.sort(lengths);
        }
        int[] res = new int[points.length];
        var ind = 0;
        for (var p : points) {
            var py = p[1];
            for (int i = py; i <= 100; i++) {
                if (map.containsKey(i)) {
                    var lengths = map.get(i);
                    var currentNumber = lengths.size() - findClosest(lengths, p[0]);
                    res[ind] += currentNumber;
                }
            }
            ind++;
        }
        return res;
    }

    private int findClosest(List<Integer> lengths, int x) {
        if (x <= lengths.get(0)) {
            return 0;
        }
        var size = lengths.size();
        if (x > lengths.get(size - 1)) {
            return size;
        }
        var left = 0;
        var right = size - 1;
        var closest = size;
        while (right >= left) {
            var midInd = left + (right - left) / 2;
            Integer midVal = lengths.get(midInd);
            if (x == midVal) {
                return midInd;
            } else if (x < midVal) {
                closest = midInd;
                right = midInd-1;
            } else {
                left = midInd+1;
            }
        }
        return closest;
    }

}
