package com.home.algorithms.score;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class BestAverageScore {

    public Pair<String, Integer> findWithHashMap(Object[][] studentsScores) {
        Map<String, List<Integer>> table = new HashMap<>();
        for (int i = 0; i < studentsScores.length; i++) {
            String name = (String) ((Map.Entry) studentsScores[i][0]).getKey();
            Integer score = (Integer) ((Map.Entry) studentsScores[i][0]).getValue();
            if (table.get(name) != null) {
                table.get(name).add(score);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(score);
                table.put(name, list);
            }
        }
        return table.entrySet().stream()
                .map(e -> transformToPairWithAverageScore(e.getKey(), e.getValue()))
                .max(Comparator.comparingInt(Pair::getRight))
                .orElse(null);
    }

    private Pair<String, Integer> transformToPairWithAverageScore(String s, List<Integer> scores) {
        Integer avg = (int) scores.stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0);
        return Pair.of(s, avg);
    }
}
