package com.home.algorithms.string

import spock.lang.Specification

class CompressStringTest extends Specification {

    CompressString compressString = new CompressString()

    def 'should compress string with repetitive symbols'() {
        given: 'input string'

        when: 'compress method called'
        def res = compressString.compress(input)

        then: 'check output as expected'
        res == expected

        where:
        input    | expected
        "abbbcc" |  "a1b3c2"
        "abbbc" |  "a1b3c1"
    }

    def 'should compress string with non-repetitive symbols'() {
        given: 'input string'
        def input = "abcd"

        when: 'compress method called'
        def res = compressString.compress(input)

        then: 'check output as expected'
        res == "a1b1c1d1"
    }

    def 'should return empty string for empty input'() {
        given: 'input string'

        when: 'compress method called'
        def res = compressString.compress(input)

        then: 'check output as expected'
        res == expected

        where: 'input params'
        input | expected
        ""    | ""
        null  | ""
    }

    def 'should compress string of few symbols'() {
        given: 'input string'

        when: 'compress method called'
        def res = compressString.compress(input)

        then: 'check output as expected'
        res == expected

        where: 'input params'
        input   |  expected
        "a"     |  "a1"
        "aa"    |  "a2"
        "ab"    |  "a1b1"
    }
}
