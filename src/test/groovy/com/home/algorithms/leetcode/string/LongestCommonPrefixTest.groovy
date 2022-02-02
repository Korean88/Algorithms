package com.home.algorithms.leetcode.string

import spock.lang.Specification

class LongestCommonPrefixTest extends Specification {

    def "should find longest common prefix"() {
        given: "instance"
        def instance = new LongestCommonPrefix()

        when: "method called"
        def actual = instance.longestCommonPrefix(input)

        then: "verify"
        actual == expected

        where: "parameters"
        input                                    | expected
        ["flower", "flow", "flight"] as String[] | "fl"
        ["dog", "racecar", "car"] as String[]    | ""
        ["dogg", "dodge"] as String[]            | "do"
        null                                     | null
        [] as String[]                           | ""
        ["", ""] as String[]                     | ""
        [""] as String[]                         | ""
    }
}
