package com.home.algorithms.string

import spock.lang.Specification

class PermutationsTest extends Specification {

    Permutations permutations = new Permutations()

    def 'test permutations of a given String'() {
        given: 'parameterized'
        when: 'method called'
        def res = permutations.permutations(input)

        then: 'verify'
        res == expected as List<String>

        where: 'params'
        input | expected
        "abc" | ["abc", "acb", "bac", "bca", "cab", "cba"]
        "ab"  | ["ab", "ba"]
        "a"   | ["a"]
    }

}
