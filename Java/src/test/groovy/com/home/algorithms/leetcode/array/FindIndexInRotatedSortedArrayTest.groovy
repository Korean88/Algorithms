package com.home.algorithms.leetcode.array

import spock.lang.Specification

class FindIndexInRotatedSortedArrayTest extends Specification {

    def "should find the position of the target int or return -1"() {
        given: 'instance'
        def instance = new FindIndexInRotatedSortedArray()

        when: 'method called'
        def res = instance.search(nums, target)

        then: 'verify result'
        res == expected

        where: 'parameters'
        nums                              | target | expected
        [4, 5, 6, 7, 0, 1, 2] as int[]    | 0      | 4
        [4, 5, 6, 7, 0, 1, 2] as int[]    | 3      | -1
        [5, 6, 7, 0, 1, 2, 3, 4] as int[] | 0      | 3
        [5, 6, 7, 0, 1] as int[]          | 1      | 4
        [1, 3] as int[]                   | 1      | 0
        [1] as int[]                      | 0      | -1
        [1] as int[]                      | 1      | 0
        [] as int[]                       | 0      | -1
    }
}
