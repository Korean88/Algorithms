package com.home.algorithms.leetcode.string;

import java.util.*;

public class WordLadder {

    int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        //create map of generic keys and lists of words
        Map<String, List<String>> generics = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String generic = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> wordsForGeneric = generics.getOrDefault(generic, new ArrayList<>());
                wordsForGeneric.add(word);
                generics.put(generic, wordsForGeneric);
            }
        }

        //create a queue with first word and subsequent words and number of steps
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        //poll from queue, find possible generics, find generics in map,
        //push every word from list to queue and increase number
        while (!queue.isEmpty()) {
            Pair<String, Integer> currentPair = queue.poll();
            String currentWord = currentPair.left;
            if (currentWord.equals(endWord)) return currentPair.right;
            for (int i = 0; i < currentWord.length(); i++) {
                String generic = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1);
                List<String> wordsForGeneric = generics.getOrDefault(generic, new ArrayList<>());
                wordsForGeneric.remove(currentWord);
                for (String w : wordsForGeneric) {
                    queue.add(new Pair<>(w, currentPair.right + 1));
                }
            }
        }
        return 0;
    }

    private static class Pair<L, R> {
        L left;
        R right;

        Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }
    }

}
