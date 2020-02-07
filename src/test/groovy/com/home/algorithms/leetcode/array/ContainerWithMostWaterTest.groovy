package com.home.algorithms.leetcode.array


import spock.lang.Specification

class ContainerWithMostWaterTest extends Specification {

    ContainerWithMostWater subject = new ContainerWithMostWater()

    def 'test solution'() {
        given: 'parameters'
        when: 'method called'
        def res = subject.maxArea(height as int[])

        then: 'verify'
        res == expected

        where: 'parameters'
        height                       | expected
        [1, 8, 6, 2, 5, 4, 8, 3, 7]  | 49
        [8, 10, 6, 2, 5, 4, 8, 3, 7] | 56
        []                           | 0
        null                         | 0
    }
}
