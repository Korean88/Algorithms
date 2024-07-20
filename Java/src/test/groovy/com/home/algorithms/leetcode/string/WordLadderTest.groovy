package com.home.algorithms.leetcode.string

import spock.lang.Specification

class WordLadderTest extends Specification {

    WordLadder wordLadder = new WordLadder()

    def 'test word ladder'() {
        given: 'parameterized test'
        when: 'method called'
        def res = wordLadder.ladderLength(beginWord, endWord, wordList as List<String>)

        then: 'verify result'
        res == expected

        where: 'parameters'
        beginWord | endWord | wordList                                   | expected
        "hit"     | "cog"   | ["hot", "dot", "dog", "lot", "log", "cog"] | 5
        "hit"     | "hot"   | ["hot", "dot", "dog", "lot", "log", "cog"] | 2
        "a"       | "c"     | ["a", "b", "c"]                            | 1
    }
}
