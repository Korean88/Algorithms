package com.home.algorithms.amz.easy

import spock.lang.Specification

import static com.home.algorithms.leetcode.listnode.ListNodeUtils.createListNode

class MergeTwoSortedListsTest extends Specification {

    def instance = new MergeTwoSortedLists()

    def 'test merge iterative'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.mergeIterative(createListNode(a1), createListNode(a2))

        then: 'verify'
        res == createListNode(expected)

        where: 'parameters'
        a1                | a2                | expected
        [1, 2, 4]         | [1, 3, 4]         | [1, 1, 2, 3, 4, 4]
        [-2, 0, 1, 3, 5]  | [-3, -1, 0, 2, 4] | [-3, -2, -1, 0, 0, 1, 2, 3, 4, 5]
        null              | [-3, -1, 0, 2, 4] | [-3, -1, 0, 2, 4]
        [-3, -1, 0, 2, 4] | null              | [-3, -1, 0, 2, 4]
        [1]               | [2]               | [1, 2]
        null              | null              | null
    }

    def 'test merge recursive'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.mergeRecursive(createListNode(a1), createListNode(a2))

        then: 'verify'
        res == createListNode(expected)

        where: 'parameters'
        a1                | a2                | expected
        [1, 2, 4]         | [1, 3, 4]         | [1, 1, 2, 3, 4, 4]
        [-2, 0, 1, 3, 5]  | [-3, -1, 0, 2, 4] | [-3, -2, -1, 0, 0, 1, 2, 3, 4, 5]
        null              | [-3, -1, 0, 2, 4] | [-3, -1, 0, 2, 4]
        [-3, -1, 0, 2, 4] | null              | [-3, -1, 0, 2, 4]
        [1]               | [2]               | [1, 2]
        null              | null              | null
    }
}
