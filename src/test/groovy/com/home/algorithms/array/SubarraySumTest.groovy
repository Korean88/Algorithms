package com.home.algorithms.array

import spock.lang.Specification

class SubarraySumTest extends Specification {

    SubarraySum subject = new SubarraySum()

    def 'test sliding windows'() {
        given: 'array'
        when: 'method called'
        def sum = subject.calculateMaxSubarraySum(input as int[])

        then: 'check result'
        sum == expected

        where: 'parameters'
        input                             | expected
//        [1, -3, 3, -4, 10, -1, 2, -3, -5] | 11
        [-1, 3, 4, -2, 1]                 | 7
//        [-3]                              | -3
//        [-9, 9, -9]                       | 0
//        [-9, 9]                           | 0
    }
}
