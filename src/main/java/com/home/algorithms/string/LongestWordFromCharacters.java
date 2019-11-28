package com.home.algorithms.string;


import java.util.*;
import java.util.stream.Collectors;

public class LongestWordFromCharacters {

    public List<String> findWords(char[] array, Set<String> dictionary) {
        List<String> res = new ArrayList<>();
        List<String> sortedDictionary = dictionary.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        for (int i = sortedDictionary.size() - 1; i >=0; i--) {
            String currentWord = sortedDictionary.get(i);
            int maxSize = currentWord.length();
            if (!res.isEmpty() && maxSize < res.get(0).length()) {
                return res;
            }
            if (allCharactersInArray(currentWord, array)) {
                res.add(currentWord);
            }
        }
        return res;
    }

    private boolean allCharactersInArray(String currentWord, char[] array) {
        if (currentWord.length() > array.length) {
            return false;
        }
        StringBuilder allowable = new StringBuilder(new String(array));
        for (int i = 0; i < currentWord.length(); i++) {
            int currentCharIdx = allowable.indexOf("" + currentWord.charAt(i));
            if (currentCharIdx != -1) {
                allowable.deleteCharAt(currentCharIdx);
            } else {
                return false;
            }
        }
        return true;
    }
}