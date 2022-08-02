package com.home.algorithms.leetcode.phone

import spock.lang.Specification

class DialpadTest extends Specification {

    def "should return all possible combinations"() {
        given: "Dialpad instance"
        def dialpad = new Dialpad()

        when: "method call"
        def result = dialpad.letterCombinations(digits)

        then: "compare"
        result == expected

        where: "parameters"
        digits | expected
        "23"   | ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        "2"    | ["a", "b", "c"]
        ""     | []
    }
}
