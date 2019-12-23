package com.home.algorithms.leetcode.string

import spock.lang.Specification

class LongestUniqueStringTest extends Specification {

    LongestUniqueString longestUniqueString = new LongestUniqueString()

    def 'test solution with Map'() {
        given: 'input Strings'
        when: 'method called'
        def res = longestUniqueString.slidingWindowsOptimized(input)

        then: 'check result'
        res == expected

        where:
        input           | expected
        "aqwertpapeiu"  | 7
        "aqwebbtapbiu"  | 6
        "aaaa"          | 1
        "aqwerbyabnmdfa"| 7
    }

    def 'test sliding windows solution'() {
        given: 'input Strings'
        when: 'method called'
        def res = longestUniqueString.slidingWindows(input)

        then: 'check result'
        res == expected

        where:
        input           | expected
        "aqwertpapeiu"  | 7
        "aqwebbtapbiu"  | 6
        "aaaa"          | 1
        "aqwerbyabnmdfa"| 7
        "abcdebfc"      | 5
    }

}
