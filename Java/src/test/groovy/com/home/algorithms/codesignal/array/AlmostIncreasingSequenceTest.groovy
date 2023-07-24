package com.home.algorithms.codesignal.array

import com.home.algorithms.codesignal.array.AlmostIncreasingSequence
import spock.lang.Specification

class AlmostIncreasingSequenceTest extends Specification {

    def instance = new AlmostIncreasingSequence()

    def 'test if the sequence is increasing if 1 element is removed from the array'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.solution(arr as int[])

        then: 'verify'
        res == expected

        where: 'parameters'
        arr                    | expected
        [1, 3, 2]              | true
        [3, 1, 2]              | true
        [2, 3, 1]              | true
        [2, 3, 2]              | true
        [2, 1, 3]              | true
        [3, 2, 1]              | false
        [1, 3, 2, 1]           | false
        [10, 1, 2, 3, 4, 5]    | true
        [1, 2, 3, 4, 99, 5, 6] | true
        [1, 2, 3, 4, 3, 6]     | true
        [1, 2, 1, 2]           | false
    }
}
