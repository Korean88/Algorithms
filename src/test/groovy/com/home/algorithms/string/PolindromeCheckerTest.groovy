package com.home.algorithms.string

import spock.lang.Specification

class PolindromeCheckerTest extends Specification {

    PolindromeChecker polindromeChecker = new PolindromeChecker()

    def "test polindrome"() {
        given: "input string"
        when: "method called"
        boolean res = polindromeChecker.isPolindrome(input)

        then: "check expected"
        res == expected

        where: "parameters"
        input   | expected
        ""      | false
        null    | false
        "a"     | true
        "abba"  | true
        "abbb"  | false
        "1233211"| false
    }
}
