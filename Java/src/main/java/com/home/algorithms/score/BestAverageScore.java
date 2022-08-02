package com.home.algorithms.score;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

public class BestAverageScore {

    Object[] bestAvgScore(Object[][] scores) {
        Map<Object, List<Object>> studentScores = Arrays.stream(scores)
                .collect(groupingBy(s -> s[0], mapping(s -> s[1], Collectors.toList())));
        Object[] res = new Object[2];
        for (Map.Entry<Object, List<Object>> entry:studentScores.entrySet()) {
            double avg = entry.getValue().stream()
                    .mapToInt(o -> (int) o)
                    .average()
                    .orElse(Double.MIN_VALUE);
            if (res[1] == null || avg > (double)res[1]) {
                res[0] = entry.getKey();
                res[1] = avg;
            }
        }
        return res;
    }
}
