package com.home.algorithms.codesignal.array;

import java.util.HashSet;

public class HouseSegments {

    int[] solution(int[] houses, int[] queries) {
        int[] res = new int[queries.length];
        var housesSet = new HashSet<Integer>();
        var segments = 1;
        int prevHouse = houses[0];
        housesSet.add(prevHouse);
        for (int i = 1; i < houses.length ; i++) {
            housesSet.add(houses[i]);
            if (houses[i] > prevHouse + 1) {
                segments++;
            }
            prevHouse = houses[i];
        }
        int resIndex = 0;
        for (int q : queries) {
            if (housesSet.contains(q - 1) && housesSet.contains(q + 1)) {
                res[resIndex++] = ++segments;
            } else if (housesSet.contains(q - 1) || housesSet.contains(q + 1)) {
                res[resIndex++] = segments;
            } else {
                res[resIndex++] = --segments;
            }
            housesSet.remove(q);
        }
        return res;
    }
}
