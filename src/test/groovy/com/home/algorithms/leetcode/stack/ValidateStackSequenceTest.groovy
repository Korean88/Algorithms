package com.home.algorithms.leetcode.stack

import spock.lang.Specification

class ValidateStackSequenceTest extends Specification {

    ValidateStackSequence validator = new ValidateStackSequence()

    def 'test method with 2 loops'() {
        given: 'parameterized test'
        when: 'validate called'
        def res = validator.validateStackSequences(pushed as int[], popped as int[])

        then: 'verify'
        res == expected

        where: 'parameters'
        pushed          | popped               | expected
        [1, 2, 3, 4, 5] | [4, 5, 3, 2, 1]      | true
        [1, 2, 3, 4, 5] | [1, 2, 3, 4, 5]      | true
        [1, 2, 3, 4, 5] | [5, 4, 3, 2, 1]      | true
        [1, 2, 3, 4, 5] | [3, 2, 4, 1, 5]      | true
        [1, 2, 3, 4, 5] | [2, 3, 1, 4, 5]      | true
        [1, 2, 3, 4, 5] | [2, 1, 3, 4, 5]      | true
        [1, 2, 3, 4, 5] | [1, 3, 4, 2, 5]      | true
        [1, 2, 3, 4, 5] | [4, 5, 2, 1, 3]      | false
        [1, 2, 3, 4, 5] | [5, 4, 3, 1, 2]      | false
        [1, 2, 3, 4, 5] | [5, 4, 3, 2]         | false
        [1, 2, 3, 4, 5] | [5, 4, 3, 2, 0]      | false
        [1, 2, 3, 4, 5] | [1, 2, 5, 4, 4]      | false
        [1, 2, 3, 4, 5] | [11, 12, 13, 14, 15] | false
    }
}
