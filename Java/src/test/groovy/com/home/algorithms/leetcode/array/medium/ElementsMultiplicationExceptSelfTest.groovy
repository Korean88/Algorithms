package com.home.algorithms.leetcode.array.medium


import spock.lang.Specification

class ElementsMultiplicationExceptSelfTest extends Specification {

    def instance = new ElementsMultiplicationExceptSelf()

    def 'should return array where each element is a product of multiplication of all other elements except itself'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.productExceptSelf(input as int[])

        then: 'verify'
        res == expected as int[]

        where: 'parameters'
        input             | expected
        [1, 2, 3, 4]      | [24, 12, 8, 6]
        [-1, 1, 0, -3, 3] | [0, 0, 9, 0, 0]
        [-1, 1]           | [1, -1]
    }

}