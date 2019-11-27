package com.home.algorithms.string;

import java.util.ArrayList;
import java.util.List;

public class UniqueStringsOfKCharacters {

    public List<String> bruteForce(char[] input, int numberOfChars) {
        List<String> res = new ArrayList<>();
        for (int i=0; i<input.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<numberOfChars; j++) {
                int idx = j!=0 ? i % j : i;
                sb.append(input[idx]);
                for (int k=0; k<3; k++) {
                    int idx2 = k!=0 ? i % k : i;
                    sb.append(input[idx2]);
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }

    private int mod(int i) {
        if (i < 0) {
            return -1*i;
        }
        return i;
    }
}
