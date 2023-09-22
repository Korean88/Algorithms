package com.home.algorithms.codesignal.array

import spock.lang.Specification

class StringRearrangementTest extends Specification {

    def instance = new StringRearrangement()

    def 'should determine if Strings in an array can be rearranged so that each neighboring Strings differ by 1 symbol'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.solution(input as String[])

        then: 'verify'
        res == expected

        where: 'parameters'
        input                                                    | expected
        ["aba", "bbb", "bab"] | false
        ["abb", "bbb", "aba"] | true
        ["bbb", "bba", "aba", "abb", "aab"] | true
        ["bba", "aab", "aba", "abb", "bbb"] | true
    }
}
