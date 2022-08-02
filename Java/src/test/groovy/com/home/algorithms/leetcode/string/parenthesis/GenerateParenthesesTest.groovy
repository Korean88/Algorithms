package com.home.algorithms.leetcode.string.parenthesis

import spock.lang.Specification

class GenerateParenthesesTest extends Specification {

    def 'should generate String parentheses'() {
        given: 'instance'
        def instance = new GenerateParentheses()

        when: 'method called'
        def actual = instance.generateParentheses(input)

        then: 'validate'
        actual.containsAll(expected)

        where: 'parameters'
        input | expected
        1     | ["()"]
        2     | ["()()", "(())"]
        3     | ["()()()", "(())()", "(()())", "((()))", "()(())"]
    }

    def 'should generate empty List for n=0'() {
        given: 'instance'
        def instance = new GenerateParentheses()

        when: 'method called'
        def actual = instance.generateParentheses(0)

        then: 'validate'
        actual.isEmpty()
    }
}
