package com.home.algorithms.amz.hard


import spock.lang.Specification

class LengthOfTheLongestValidSubstringTest extends Specification {

    def instance = new LengthOfTheLongestValidSubstring()

    def 'test validate 3 pointers'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.longestValidSubstring(word, forbidden)

        then: 'verify'
        res == expected

        where: 'parameters'
        word       | forbidden                         | expected
        "cbaaaabc" | ["aaa", "cb"]                     | 4
        "leetcode" | ["de", "le", "e"]                 | 4
        "cabba"    | ["aaba", "abba", "acabb", "cabb"] | 3
        "bcbcb"    | ["cbbbb", "bcbcb", "cbc", "bcb"]  | 2
        "abaca"    | ["aca", "aba", "acc", "aba"]      | 3
        "bcccccc"  | ["bcaca", "bbaca", "ccc", "cccc"] | 3
        "acabcab"  | ["bbcbb", "acac", "cab", "abcab"] | 4
    }
}
