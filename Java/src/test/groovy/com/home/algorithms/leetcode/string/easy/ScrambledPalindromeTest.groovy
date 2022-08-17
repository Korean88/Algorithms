package com.home.algorithms.leetcode.string.easy

import spock.lang.Specification

class ScrambledPalindromeTest extends Specification {

    def "should tell if String is a scrambled palindrome"() {
        given: 'instance'
        def instance = new ScrambledPalindrome()

        when: 'method called'
        def res = instance.isScrambledPalindrome(input)

        then: 'verify result'
        res == expected

        where: 'parameters'
        input     | expected
        "otorr"   | true
        "abc"     | false
        "bbbaabc" | true
        "baba"    | true
        "127271"  | true
        "a"       | true
        ""        | false
        null      | false
    }
}
