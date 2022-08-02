package com.home.algorithms.leetcode.array

import spock.lang.Specification

class HeapsAlgorithmPermutationTest extends Specification {

    def instance = new HeapsAlgorithmPermutation()

    def "should return permutations using recursion"() {
        given: 'input array'

        when: 'recursive method called'
        def res = instance.recursion(input)

        then: 'compare result'
        for (int i = 0; i < res.size(); i++) {
            res[i] == expected[i]
        }

        where: 'parameters'
        input              | expected
        [1, 2] as int[]    | [[1, 2] as int[], [2, 1] as int[]]
        [1, 2, 3] as int[] | [[1, 2, 3] as int[], [2, 1, 3] as int[], [3, 1, 2] as int[], [1, 3, 2] as int[], [2, 3, 1] as int[], [3, 2, 1] as int[]]
    }

    def "should return permutations using iterative approach"() {
        given: 'input array'

        when: 'method called'
        def res = instance.iterative(input)

        then: 'compare result'
        for (int i = 0; i < res.size(); i++) {
            res[i] == expected[i]
        }

        where: 'parameters'
        input              | expected
        [1, 2] as int[]    | [[1, 2] as int[], [2, 1] as int[]]
        [1, 2, 3] as int[] | [[1, 2, 3] as int[], [2, 1, 3] as int[], [3, 1, 2] as int[], [1, 3, 2] as int[], [2, 3, 1] as int[], [3, 2, 1] as int[]]
    }

}
