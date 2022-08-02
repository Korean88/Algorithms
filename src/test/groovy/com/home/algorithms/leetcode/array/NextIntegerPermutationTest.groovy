package com.home.algorithms.leetcode.array

import spock.lang.Specification

class NextIntegerPermutationTest extends Specification {

    def instance = new NextIntegerPermutation()

    def "Should find next permutation of array"() {
        given: 'array'

        when: 'method called'
        instance.nextPermutation(input)

        then: 'check modified input array'
        input == expected

        where: 'parameter'
        input                 | expected
        [1, 2, 3] as int[]    | [1, 3, 2] as int[]
        [2, 1, 3] as int[]    | [2, 3, 1] as int[]
        [3, 2, 1] as int[]    | [1, 2, 3] as int[]
        [2, 2, 3, 1] as int[] | [2, 3, 1, 2] as int[]
        [2, 5, 3, 1] as int[] | [3, 1, 2, 5] as int[]
        [1, 1, 5] as int[]    | [1, 5, 1] as int[]
        [1, 2] as int[]       | [2, 1] as int[]
        [2, 1] as int[]       | [1, 2] as int[]
    }
}
