package com.home.algorithms.array.subarray.sum

import com.home.algorithms.array.subarray.sum.SubarraySum
import spock.lang.Specification

class SubarraySumTest extends Specification {

    SubarraySum subject = new SubarraySum()

    def 'test bruteforce'() {
        given: 'array'
        when: 'method called'
        def sum = subject.bruteForce(input as int[])

        then: 'check result'
        sum == expected

        where: 'parameters'
        input                             | expected
        [1, -3, 3, -4, 10, -1, 2, -3, -5] | 11
        [-1, 3, 4, -2, 1]                 | 7
        [-1, -3, -4, -2, -1]              | -1
        [100, -4, 2, -5, 110, -1000]      | 203
        [-3]                              | -3
        [-9, 9, -9]                       | 9
        [-9, 9]                           | 9
    }

    def 'test current max recalculation'() {
        given: 'array'
        when: 'method called'
        def sum = subject.calculateMaxSubarraySum(input as int[])

        then: 'check result'
        sum == expected

        where: 'parameters'
        input                             | expected
        [1, -3, 3, -4, 10, -1, 2, -3, -5] | 11
        [-1, 3, 4, -2, 1]                 | 7
        [-1, -3, -4, -2, -1]              | -1
        [100, -4, 2, -5, 110, -1000]      | 203
        [-3]                              | -3
        [-9, 9, -9]                       | 9
        [-9, 9]                           | 9
    }
}
