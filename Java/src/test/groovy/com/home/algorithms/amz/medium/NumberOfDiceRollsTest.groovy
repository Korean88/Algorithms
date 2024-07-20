package com.home.algorithms.amz.medium


import spock.lang.Specification

class NumberOfDiceRollsTest extends Specification {

    def instance = new NumberOfDiceRolls()

    def 'test dynamic programming approach'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.numRollsToTarget(n, k, target)

        then: 'verify'
        res == expected

        where: 'parameters'
        n  | k  | target | expected
        2  | 8  | 4      | 3
        2  | 8  | 5      | 4
        3  | 8  | 5      | 6
        3  | 8  | 6      | 10
        3  | 8  | 9      | 7

        1  | 6  | 3      | 1
        2  | 6  | 7      | 6
        30 | 30 | 500    | 222616187
    }
}
