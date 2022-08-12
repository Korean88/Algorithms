package com.home.algorithms.leetcode.array

import spock.lang.Specification

class TrappingRainWaterTest extends Specification {

    def "should calculate trapping water"() {
        given: 'instance'
        def instance = new TrappingRainWater()

        when: 'method called'
        def res = instance.trap(given)

        then: 'verify results'
        res == expected

        where: 'parameters'
        given                                         | expected
        [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] as int[] | 6
        [4, 2, 0, 3, 2, 5] as int[]                   | 9
        [4, 2, 4] as int[]                            | 2
        [0, 0, 0] as int[]                            | 0
        [10, 20] as int[]                             | 0
        [3, 3, 3, 3] as int[]                         | 0
        [1, 2, 3, 4] as int[]                         | 0
        [6, 5, 4, 3] as int[]                         | 0
        [] as int[]                                   | 0
        [10] as int[]                                 | 0
    }
}
