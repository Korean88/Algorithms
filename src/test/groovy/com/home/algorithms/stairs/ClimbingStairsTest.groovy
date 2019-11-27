package com.home.algorithms.stairs

import spock.lang.Specification

class ClimbingStairsTest extends Specification {

    ClimbingStairs climbingStairs = new ClimbingStairs();

    def 'test recursive'() {
        given:
        when: 'call recursive method'
        int res = climbingStairs.countRecursive(input)

        then: 'check result'
        res == expected

        where: 'parameters'
        input   |  expected
        1       |  1
        2       |  2
        3       |  3
        4       |  5
        5       |  8
    }

    def 'test loop'() {
        given:
        when: 'call loop method'
        int res = climbingStairs.countLoop(input)

        then: 'check result'
        res == expected

        where: 'parameters'
        input   |  expected
        1       |  1
        2       |  2
        3       |  3
        4       |  5
        5       |  8
    }

    def 'test with supplier'() {
        given:
        when: 'call loop method'
        int res = climbingStairs.countWithSupplier(input)

        then: 'check result'
        res == expected

        where: 'parameters'
        input   |  expected
        1       |  1
        2       |  2
        3       |  3
        4       |  5
        5       |  8
    }
}
