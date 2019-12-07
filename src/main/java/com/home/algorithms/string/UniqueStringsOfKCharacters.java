package com.home.algorithms.string;

import java.util.List;

public class UniqueStringsOfKCharacters {

    void find(char[] inputArray, int k, String prefix, List<String> collect) {
        if (k == 0) {
            collect.add(prefix);
            return;
        }
        for (int i = 0; i < inputArray.length; ++i) {
            String newPrefix = prefix + inputArray[i];
            find(inputArray, k - 1, newPrefix, collect);
        }
    }
}
