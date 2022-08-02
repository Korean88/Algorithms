package com.home.algorithms.leetcode.array

import spock.lang.Specification

class FourSumTest extends Specification {

    def "should find collections of 4 elements"() {
        given: "instance"
        def instance = new FourSum()

        when: "method called"
        def actual = instance.fourSum2(inputArray, inputTarget)

        then: "compare result"
        for (List<Integer> l : expected) {
            assert actual.contains(l)
        }

        where: "parameters"
        inputArray                           | inputTarget | expected
        [1, 0, -1, 0, -2, 2] as int[]        | 0           | [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
        [2, 2, 2, 2, 2] as int[]             | 8           | [[2, 2, 2, 2]]
        [-3, -2, -1, 0, 0, 1, 2, 3] as int[] | 0           | [[-3, -2, 2, 3], [-3, -1, 1, 3], [-3, 0, 0, 3], [-3, 0, 1, 2], [-2, -1, 0, 3], [-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]

    }
}
