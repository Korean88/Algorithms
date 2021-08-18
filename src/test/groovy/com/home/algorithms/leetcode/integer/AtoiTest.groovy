package com.home.algorithms.leetcode.integer

import spock.lang.Specification

class AtoiTest extends Specification {

    def atoi = new Atoi()

    def "should convert valid String to int"() {
        given: "input String"
        when: "atoi called"
        def result = atoi.myAtoi(input)

        then: "compare with the desired result"
        result == expected

        where: "parameters"
        input                   | expected
        "123"                   | 123
        "+123"                  | 123
        " +123"                 | 123
        " -123  "               | -123
        " -123 a "              | -123
        " -123  asd"            | -123
        " -123asd"              | -123
        "asd123"                | 0
        "-asd123"               | 0
        "-91283472332"          | -2147483648
        "20000000000000000000"  | 2147483647
        "  0000000000012345678" | 12345678
    }
}
