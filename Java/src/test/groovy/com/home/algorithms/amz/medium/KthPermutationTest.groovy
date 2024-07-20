package com.home.algorithms.amz.medium

import com.home.algorithms.amz.hard.KthPermutation
import spock.lang.Specification

class KthPermutationTest extends Specification {

    def instance = new KthPermutation()

    def "should return kth permutation of a String"() {
        given: 'the number of digits in the input String'

        when: 'method called'
        def res = instance.getPermutation(n, k)

        then: 'compare result'
        res == expected

        where: 'parameters'
        n | k | expected
        2 | 2 | "21"
        3 | 1 | "123"
        3 | 2 | "132"
        3 | 3 | "213"
        4 | 9 | "2314"
        4 | 14 | "3142"
    }
}
