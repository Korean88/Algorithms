package com.home.algorithms.leetcode.listnode

import spock.lang.Specification

import static com.home.algorithms.leetcode.listnode.ListNodeUtils.createListNode
import static com.home.algorithms.leetcode.listnode.ListNodeUtils.createListNodes

class MergeKSortedListsTest extends Specification {
    def "should merge multiple sorted lists"() {
        given: 'instance'
        def instance = new MergeKSortedLists()

        when: 'method called'
        def res = instance.mergeKLists(given)

        then: 'verify result'
        res == expected

        where: 'parameters'
        given                                           | expected
        createListNodes([[1, 4, 5], [1, 3, 4], [2, 6]]) | createListNode([1, 1, 2, 3, 4, 4, 5, 6])
        new ListNode[0]                                 | null
        [null] as ListNode[]                          | null
    }

}
