package com.home.algorithms.amz.medium

import spock.lang.Specification

class CountNicePairsInArrayTest extends Specification {

    def instance = new CountNicePairsInArray()

    def 'test method'() {
        given: 'array'
        when: 'method called'
        def res = instance.countNicePairs(nums)

        then: 'check result'
        res == expected

        where:
        nums                          | expected
        [42, 11, 1, 97] as int[]      | 2
        [13, 10, 35, 24, 76] as int[] | 4
    }
}
