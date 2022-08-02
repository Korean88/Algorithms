package com.home.algorithms.string;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    List<String> permutations(String s) {
        List<String> res = new ArrayList<>();
        construct(res, "", s);
        return res;
    }

    private void construct(List<String> set, String prefix, String remainder) {
        if (remainder.length()==0) {
            set.add(prefix);
        } else {
            for (int i=0; i<remainder.length(); i++) {
                construct(set, prefix + remainder.charAt(i), remainder.substring(0, i) + remainder.substring(i+1));
            }
        }
    }
}
