package com.home.algorithms.array.difference

import org.apache.commons.lang3.tuple.Pair
import spock.lang.Specification

class FindElementsWithDifferenceTest extends Specification {

    FindElementsWithDifference findElementsWithDifference = new FindElementsWithDifference()

    def 'bruteforce should find all pairs with difference 2'() {
        given: 'input and expected result'
        def input = [1, 7, 5, 9, 2, 12, 3] as int[]
        def expected = new HashSet([Pair.of(1, 3), Pair.of(7, 5), Pair.of(7, 9), Pair.of(5, 3)])

        when: 'find all pairs'
        def res = findElementsWithDifference.findPairWithDifferenceBruteForce(input, 2)

        then: 'compare result with expected'
        res == expected
    }

    def 'findWithSorting should find all pairs with given difference'() {
        given: 'input and expected result'
        def input = inputArray as int[]

        when: 'find all pairs'
        def res = findElementsWithDifference.findWithSorting(input, givenDifference)

        then: 'compare result with expected'
        res == expected as Set

        where: 'parameters'
        inputArray             | givenDifference | expected
        [1, 7, 5, 9, 2, 12, 3] | 2               | [Pair.of(1, 3), Pair.of(5, 7), Pair.of(3, 5), Pair.of(7, 9)]
        [1, 7]                 | 6               | [Pair.of(1, 7)]
        [1]                    | 6               | []
        []                     | 6               | []
        [1, 7, 5, 9, 2, 12, 3] | 60              | []
    }
}
