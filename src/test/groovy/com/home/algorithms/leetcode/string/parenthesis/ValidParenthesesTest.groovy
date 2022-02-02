package com.home.algorithms.leetcode.string.parenthesis

import com.home.algorithms.leetcode.string.parenthesis.ValidParentheses
import spock.lang.Specification

class ValidParenthesesTest extends Specification {

    def 'should validate String parentheses'() {
        given: 'instance'
        def instance = new ValidParentheses()

        when: 'method called'
        def actual = instance.isValid(input)

        then: 'validate'
        actual == expected

        where: 'parameters'
        input    | expected
        "()"     | true
        "({[]})" | true
        "({[})"  | false
        ""       | false
        "{"      | false
    }
}
