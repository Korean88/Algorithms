package com.home.algorithms.leetcode.array

import spock.lang.Specification

class SubarraySumEqualsKTest extends Specification {

    def 'should find maximum number of subarrays with the given sum'() {
        given: 'instance'
        def instance = new SubarraySumEqualsK()

        when: 'method called'
        def actual = instance.subarraySum(array, k)

        then: 'validate'
        actual == expected

        where: 'parameters'
        array                    | k  | expected
        [1, 1, 1] as int[]       | 2  | 2
        [1, 2, 3] as int[]       | 3  | 2
        [1, 2, 0, 4, 4] as int[] | 4  | 3
        [1, 2, 3] as int[]       | 33 | 0
        [-1, -1, 1] as int[]     | 0  | 1
        [-1, -1, 1, -1] as int[] | 0  | 2
        [-1, -1, 2, -2] as int[] | 0  | 2
    }
}
