package com.home.algorithms.leetcode.string

import spock.lang.Specification

class WordSubsetsTest extends Specification {

    WordSubsets wordSubsets = new WordSubsets()

    def 'should return 3 words where both "e" and "o" are present'() {
        given: 'array A and array B'
        def A = ["amazon", "apple", "facebook", "google", "leetcode"] as String[]
        def B = arrayB as String[]

        when: "method called"
        def res = wordSubsets.bruteForceWordSubsets(A, B)

        then: 'result should contain 3 words from A'
        res == expected

        where: 'array B and expected result'
        arrayB              | expected
        ["e", "o"]          | ["facebook", "google", "leetcode"]
        ["l", "e"]          | ["apple", "google", "leetcode"]
        ["e", "oo"]         | ["facebook", "google"]
        ["lo", "eo"]        | ["google", "leetcode"]
        ["ec", "oc", "ceo"] | ["facebook", "leetcode"]
    }

    def 'test method with sorting'() {
        given: 'array A and array B'
        def A = ["amazon", "apple", "facebook", "google", "leetcode"] as String[]
        def B = arrayB as String[]

        when: "method called"
        def res = wordSubsets.wordSubsets(A, B)

        then: 'result should contain 3 words from A'
        res == expected

        where: 'array B and expected result'
        arrayB              | expected
        ["e", "o"]          | ["facebook", "google", "leetcode"]
        ["l", "e"]          | ["apple", "google", "leetcode"]
        ["e", "oo"]         | ["facebook", "google"]
        ["lo", "eo"]        | ["google", "leetcode"]
        ["ec", "oc", "ceo"] | ["facebook", "leetcode"]
    }
}
