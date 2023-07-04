package com.home.algorithms.leetcode.array.medium

import spock.lang.Specification

class StringCompressionTest extends Specification {

    def "should return length of compressed array"() {
        given: 'instance'
        def instance = new StringCompression()

        when: 'method called'
        def res = instance.compress(input)

        then: 'verify result'
        res == expectedCount
        for (int i = 0; i < res; i++) {
            input[i] == expectedArray[i]
        }

        where: 'parameters'
        input                                                                                 | expectedCount | expectedArray
        ['a', 'a', 'b', 'b', 'c', 'c', 'c'] as char[]                                         | 6             | ['a', '2', 'b', '2', 'c', '3', '_'] as char[]
        ['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'b', 'b', 'c', 'c', 'c'] as char[] | 7             | ['a', '1', '0', 'b', '2', 'c', '3', '_', '_', '_', '_', '_', '_', '_', '_'] as char[]
        ['a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c'] as char[] | 7             | ['a', '2', 'b', '1', '0', 'c', '3', '_', '_', '_', '_', '_', '_', '_', '_'] as char[]
        ['a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'] as char[] | 7             | ['a', '2', 'b', '2', 'c', '1', '1', '_', '_', '_', '_', '_', '_', '_', '_'] as char[]
        ['a', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'] as char[]      | 6             | ['a', 'b', '2', 'c', '1', '1', '_', '_', '_', '_', '_', '_', '_', '_'] as char[]
        ['a', 'a', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'] as char[]      | 6             | ['a', '2', 'b', 'c', '1', '1', '_', '_', '_', '_', '_', '_', '_', '_'] as char[]
        ['a', 'a', 'b', 'b', 'c'] as char[]                                                   | 5             | ['a', '2', 'b', '2', 'c'] as char[]
        ['a', 'b', 'c'] as char[]                                                             | 3             | ['a', 'b', 'c'] as char[]
        ['a', 'a', 'a', 'a', 'b', 'a'] as char[]                                              | 4             | ['a', '4', 'b', 'a', '_', '_'] as char[]
    }
}
