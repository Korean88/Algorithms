package com.home.algorithms.array;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SecretSanta {

    Map<Integer, Integer> assign(int n) {
        if (n <= 1) {
            return Collections.emptyMap();
        }
        List<Integer> integersInRandomSequence = generateInRandomSequence(n);

        Map<Integer, Integer> result = new HashMap<>();
        Iterator<Integer> iterator = integersInRandomSequence.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (integersInRandomSequence.size() != 1) {
                result.put(next, integersInRandomSequence.remove(1));
            } else {
                result.put(next, integersInRandomSequence.remove(0));
            }
        }
        return result;
    }

    private List<Integer> generateInRandomSequence(int n) {
        List<Integer> res = new CopyOnWriteArrayList<>();
        List<Integer> allNumbers = IntStream.range(1, n + 1)
                .boxed()
                .collect(Collectors.toList());
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(allNumbers.size());
            res.add(allNumbers.remove(randomIndex));
        }
        return res;
    }
}
