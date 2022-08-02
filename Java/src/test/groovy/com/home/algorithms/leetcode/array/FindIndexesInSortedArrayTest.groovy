package com.home.algorithms.leetcode.array

import spock.lang.Specification

class FindIndexesInSortedArrayTest extends Specification {

    def 'should find first and last indexes of a given target number in a sorted array'() {
        given: 'instance'
        def instance = new FindIndexesInSortedArray()

        when: 'method called'
        def actual = instance.searchRange(array, target)

        then: 'validate'
        actual == expected

        where: 'parameters'
        array                           | target | expected
        [5, 7, 7, 8, 8, 10] as int[]    | 8      | [3, 4] as int[]
        [5, 5, 7, 7, 8, 8, 10] as int[] | 5      | [0, 1] as int[]
        [5, 5, 7, 7, 8, 8] as int[]     | 8      | [4, 5] as int[]
        [5, 7, 7, 8, 8, 10] as int[]    | 10     | [5, 5] as int[]
        [1, 2] as int[]                 | 2      | [1, 1] as int[]
        [1, 3] as int[]                 | 2      | [-1, -1] as int[]
        [2, 3] as int[]                 | 1      | [-1, -1] as int[]
        [2, 3] as int[]                 | 4      | [-1, -1] as int[]
        [1, 3, 5] as int[]              | 4      | [-1, -1] as int[]
        [5, 7, 7, 8, 8, 10] as int[]    | 6      | [-1, -1] as int[]
        [5, 7, 7, 8, 8, 10] as int[]    | 4      | [-1, -1] as int[]
        [5, 7, 7, 8, 8, 10] as int[]    | 9      | [-1, -1] as int[]
        [5, 7, 7, 8, 8, 10] as int[]    | 11     | [-1, -1] as int[]
        [] as int[]                     | 0      | [-1, -1] as int[]
    }

}
