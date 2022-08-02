package com.home.algorithms.leetcode.integer

import spock.lang.Specification

class DivideWithLimitationsTest extends Specification {

    def "should divide 2 integers"() {
        given: 'Instancce'
        def instance = new DivideWithLimitations()

        when: 'method called'
        def res = instance.divide(dividend, divisor)

        then: 'verify result'
        res == expected

        where: 'Parameters'
        dividend          | divisor | expected
        10                | 3       | 3
        11                | -3      | -3
        -12               | 3       | -4
        -23               | -5      | 4
        -1                | 1       | -1
        1                 | 1       | 1
        1                 | -1      | -1
        Integer.MAX_VALUE | -1      | Integer.MIN_VALUE + 1
        Integer.MAX_VALUE | 1       | Integer.MAX_VALUE
        Integer.MIN_VALUE | -1      | Integer.MAX_VALUE
        Integer.MIN_VALUE | 1       | Integer.MIN_VALUE
    }

}
