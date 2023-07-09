package com.home.algorithms.array.difference

import org.apache.commons.lang3.tuple.Pair
import spock.lang.Specification

class FindElementsWithDifferenceTest extends Specification {

    FindElementsWithDifference findElementsWithDifference = new FindElementsWithDifference()

    def 'linear should find all pairs with given difference'() {
        given: 'input and expected result'
        def input = inputArray as int[]

        when: 'find all pairs'
        def res = findElementsWithDifference.findPairWithDifferenceLinear(input, givenDifference)

        then: 'compare result with expected'
        res.containsAll(expected as Set)
        res.size() == expected.size()

        where: 'parameters'
        inputArray                 | givenDifference | expected
        [1, 7, 5, 9, 2, 12, 3]     | 2               | [Pair.of(1, 3), Pair.of(5, 7), Pair.of(3, 5), Pair.of(7, 9)]
        [1, 7]                     | 6               | [Pair.of(1, 7)]
        [1]                        | 6               | []
        []                         | 6               | []
        [1, 7, 5, 9, 2, 12, 3]     | 60              | []
        [1, 12, 7, 5, 9, 2, 12, 3] | 0               | [Pair.of(12, 12)]
        [1, 7, 5, 9, 2, 12, 3]     | 0               | []
    }

    def 'findWithSorting should find all pairs with given difference'() {
        given: 'input and expected result'
        def input = inputArray as int[]

        when: 'find all pairs'
        def res = findElementsWithDifference.findWithSorting(input, givenDifference)

        then: 'compare result with expected'
        res.containsAll(expected as Set)
        res.size() == expected.size()

        where: 'parameters'
        inputArray                 | givenDifference | expected
        [1, 7, 5, 9, 2, 12, 3]     | 2               | [Pair.of(1, 3), Pair.of(5, 7), Pair.of(3, 5), Pair.of(7, 9)]
        [1, 7]                     | 6               | [Pair.of(1, 7)]
        [1]                        | 6               | []
        []                         | 6               | []
        [1, 7, 5, 9, 2, 12, 3]     | 60              | []
        [1, 12, 7, 5, 9, 2, 12, 3] | 0               | [Pair.of(12, 12)]
        [1, 7, 5, 9, 2, 12, 3]     | 0               | []
    }
}
