package com.home.algorithms.amz.medium


import spock.lang.Specification

class MinAdjSwapsValidArrayTest extends Specification {

    def instance = new MinAdjSwapsValidArray()

    def 'test validate bst'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.minimumSwaps(input as int[])

        then: 'verify'
        res == expected

        where: 'parameters'
        input              | expected
        [3, 4, 5, 5, 3, 1] | 6
        [3, 4, 5, 5, 3, 1] | 6
        [9]                | 0
    }
}
