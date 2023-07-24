package com.home.algorithms.codesignal.array

import spock.lang.Specification

class HouseSegmentsTest extends Specification {
    def instance = new HouseSegments()

    def 'should calculate number of house segments after each query to destroy a house'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.solution(houses as int[], queries as int[])

        then: 'verify'
        res == expected as int[]

        where: 'parameters'
        houses                            | queries       | expected
        [1, 2, 3, 7, 8, 10, 11]           | [2, 10, 8]    | [4, 4, 4]
        [1, 2, 3, 5, 7]                   | [3, 1, 7]     | [3, 3, 2]
        [1]                               | [1]           | [0]
        [-100, -99, -98, -97, -50, 0, 50] | [-98, -97, 0] | [5, 4, 3]

    }
}
