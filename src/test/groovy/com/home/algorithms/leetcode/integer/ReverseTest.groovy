package com.home.algorithms.leetcode.integer

import spock.lang.Specification

class ReverseTest extends Specification {

    def reverse = new Reverse()

    def 'should reverse integer -2^31 <= x <= 2^31-1'() {
        given: 'integers from parameters'
        when: 'reverse called'
        def res = reverse.reverse(given)

        then: 'compare result'
        res == expected

        where: 'parameters'
        given | expected
        123   | 321
        -123  | -321
        0     | 0
        120   | 21
        1_534_236_469 | 0
    }
}
