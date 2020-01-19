package com.home.algorithms.leetcode.array

import spock.lang.Specification

class ThreeSumTest extends Specification {

    ThreeSum threeSum = new ThreeSum()

    def 'test solution'() {
        given: 'parameterized test'
        when: 'method called'
        def res = threeSum.threeSum(array as int[])

        then: 'validate result'
        res == expected

        where: 'parameters'
        array                 | expected
        [-1, 0, 1, 2, -1, -4] | [[-1, -1, 2], [-1, 0, 1]]
        [-1, 3, 1, 2, -2, -4] | [[-4, 1, 3], [-2, -1, 3]]
        [] | []
        null | []
    }
}
