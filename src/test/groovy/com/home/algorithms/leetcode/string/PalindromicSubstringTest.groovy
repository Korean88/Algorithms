package com.home.algorithms.leetcode.string

import spock.lang.Specification

class PalindromicSubstringTest extends Specification {

    PalindromicSubstring palindromicSubstring = new PalindromicSubstring()

    def 'test expand around center'() {
        given: 'parameterized'
        when: 'method called'
        def res = palindromicSubstring.longestPalindrome(input)

        then: 'compare with expected'
        res == expected

        where: 'parameters'
        input         | expected
        "abcabbaecdee" | "abba"
        "abcabtbaecdee" | "abtba"
        "a" | "a"
        "ac" | "a"
        "aaaa" | "aaaa"
    }
}
