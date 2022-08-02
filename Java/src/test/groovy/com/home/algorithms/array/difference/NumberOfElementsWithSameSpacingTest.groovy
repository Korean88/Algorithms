package com.home.algorithms.array.difference

import org.apache.commons.lang3.tuple.Pair
import spock.lang.Specification

class NumberOfElementsWithSameSpacingTest extends Specification {

    def 'should return max number of consecutive elements with same difference'() {
        given: 'app instance'
        def app = new NumberOfElementsWithSameSpacing()

        when: 'method called'
        def res = app.calculate(inputArray)

        then: 'compare result with expected'
        res == expected

        where: 'parameters'
        inputArray                                        | expected
        [0, 4, 8, -1000, 2000, 5000, 8000, 9000] as int[] | 4
        [1, 2, 3, 4, 5, 6, 8, 7, 9, 10] as int[]          | 6
        [1, 3, 6, 10, 11] as int[]                        | 2
        [1, 2, 3, 5, 7, 9] as int[]                       | 4
        [1, 1, 1] as int[]                                | 3
        [6, 5, 4, 2, 1, 0, -1] as int[]                   | 4
        [1, 1, 1, 2, 3, 4, 7, 18, 29, 40, 51] as int[]    | 5
        [1, 2, 3] as int[]                                | 3
        [3, 2, 1] as int[]                                | 3
        [1, 3] as int[]                                   | 2
        [1] as int[]                                      | 1
        [] as int[]                                       | 0
        null                                              | 0
    }

}
