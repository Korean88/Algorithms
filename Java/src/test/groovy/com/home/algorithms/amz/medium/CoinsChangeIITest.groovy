package com.home.algorithms.amz.medium


import spock.lang.Specification

class CoinsChangeIITest extends Specification {

    def instance = new CoinsChangeII()

    def 'test dynamic programming approach'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.change(amount, coins)

        then: 'verify'
        res == expected

        where: 'parameters'
        amount | coins              | expected
        7      | [2, 3, 5] as int[] | 2
        5      | [1, 2, 5] as int[] | 4
        3      | [2] as int[]       | 0
        10     | [10] as int[]      | 1
        7      | [10] as int[]      | 0
    }

}
