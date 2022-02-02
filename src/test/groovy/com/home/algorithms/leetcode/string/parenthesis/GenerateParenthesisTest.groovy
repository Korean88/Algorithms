package com.home.algorithms.leetcode.string.parenthesis

import spock.lang.Specification

class GenerateParenthesisTest extends Specification {

    def 'should generate String parenthesis'() {
        given: 'instance'
        def instance = new GenerateParenthesis()

        when: 'method called'
        def actual = instance.generateParenthesis(input)

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
        def instance = new GenerateParenthesis()

        when: 'method called'
        def actual = instance.generateParenthesis(0)

        then: 'validate'
        actual.isEmpty()
    }
}
