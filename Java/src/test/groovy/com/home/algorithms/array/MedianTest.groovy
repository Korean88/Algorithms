package com.home.algorithms.array

import spock.lang.Specification

class MedianTest extends Specification {
    Median median = new Median()

    def 'test median'() {
        given: 'parameterized test'
        when: 'method called'
        def res = median.findMedian(a1 as int[], a2 as int[])

        then: 'verify'
        res == expected

        where: 'parameters'
        a1                 | a2                        | expected
        [1, 3]             | [2, 4]                    | 2.5
        [-5, 3, 6, 12, 15] | [-12, -10, -6, -3, 4, 10] | 3
        [2, 3, 5, 8]       | [10, 12, 14, 16, 18, 20]  | 11
    }
}
