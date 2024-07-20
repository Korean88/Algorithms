package com.home.algorithms.leetcode.listnode


import spock.lang.Specification

import static com.home.algorithms.leetcode.listnode.ListNodeUtils.createListNode

class SwapNodesInPairsTest extends Specification {

    def 'should swap nodes in pairs'() {
        given: 'instance'
        def instance = new SwapNodesInPairs()

        when: 'method called'
        def actual = instance.swapPairs(input)

        then: 'validate'
        actual == expected

        where: 'parameters'
        input                                 | expected
        createListNode([1, 2, 3, 4] as int[]) | createListNode([2, 1, 4, 3] as int[])
        createListNode([1, 2, 3] as int[]) | createListNode([2, 1, 3] as int[])
        createListNode([1] as int[]) | createListNode([1] as int[])
        createListNode([1,2] as int[]) | createListNode([2,1] as int[])
    }

}