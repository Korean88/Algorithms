package com.home.algorithms.array.difference

import org.apache.commons.lang3.tuple.Pair
import spock.lang.Specification

class FindElementsWithDifferenceTest extends Specification {

    FindElementsWithDifference findElementsWithDifference = new FindElementsWithDifference()

    def 'bruteforce should find all pairs with difference 2'() {
        given: 'input and expected result'
        def input = [1, 7, 5, 9, 2, 12, 3] as int[]
        def expected = new HashSet([Pair.of(1,3), Pair.of(7,5), Pair.of(7,9), Pair.of(5,3)])

        when: 'find all pairs'
        def res = findElementsWithDifference.findPairWithDifferenceBruteForce(input, 2)

        then: 'compare result with expected'
        res == expected
    }
}
