package com.home.algorithms.leetcode.listnode

import com.home.algorithms.leetcode.list.RemoveNthNodeFromEnd
import spock.lang.Specification

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

    def createListNodes(List<List<Integer>> lists) {
        List<ListNode> resList = new ArrayList<>()
        for (List<Integer> l : lists) {
            def node = createListNode(l)
            if (node != null) {
                resList.add(node)
            }
        }
        return resList.toArray(new ListNode[0])
    }

    def createListNode(List<Integer> integers) {
        def res = null
        if (integers != null && integers.size() != 0) {
            ListNode head = new ListNode(integers[0])
            if (integers.size() > 1) {
                ListNode pointer = head
                for (int i = 1; i < integers.size(); i++) {
                    pointer.next = new ListNode(integers[i])
                    pointer = pointer.next
                }
            }
            res = head
        }
        return res
    }

}
