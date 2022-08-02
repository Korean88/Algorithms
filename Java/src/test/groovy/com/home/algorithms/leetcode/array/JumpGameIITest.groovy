package com.home.algorithms.leetcode.array

import spock.lang.Specification

class JumpGameIITest extends Specification {
    def 'should return min number of jumps'() {
        given: 'Jump game'
        def jump = new JumpGameII()

        when: 'method called'
        def actual = jump.jump2(input)

        then: 'verify result'
        actual == expected

        where: 'parameters'
        input                                                   | expected
        [1, 2] as int[]                                         | 1
        [1, 2, 3] as int[]                                      | 2
        [2, 3, 1] as int[]                                      | 1
        [2, 3, 1, 2, 1, 4] as int[]                             | 3
        [2, 3, 0, 1, 4] as int[]                                | 2
        [10, 6, 1, 2, 3, 4, 1, 2, 5, 0, 1, 2, 1, 2, 0] as int[] | 3
        [0] as int[]                                            | 0
    }
}
