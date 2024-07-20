package com.home.algorithms.amz.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            var key = new String(charArray);
            List<String> anagrams = map.getOrDefault(key, new ArrayList<>());
            anagrams.add(s);
            map.put(key, anagrams);
        }
        return new ArrayList<>(map.values());
    }
}
