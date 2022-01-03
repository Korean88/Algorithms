package com.home.algorithms.leetcode.list

import spock.lang.Specification

class RemoveNthNodeFromEndTest extends Specification {

    def "should remove nth node from the end of the list"() {
        given: "class instance"
        def instance = new RemoveNthNodeFromEnd()

        when: "method called"
        def actual = instance.removeWithQueue(head, n)

        then: "compare results"
        actual == expected

        where: "parameters"
        head                                | n | expected
        createListNode([1, 2, 3, 4, 5])     | 2 | createListNode([1, 2, 3, 5])
        createListNode([1, 2, 3])           | 3 | createListNode([2, 3])
        createListNode([1, 2, 3])           | 1 | createListNode([1, 2])
        createListNode([1, 2, 3])           | 2 | createListNode([1, 3])
        createListNode([1, 2, 3])           | 1 | createListNode([1, 2])
        createListNode([1])                 | 1 | null
        new RemoveNthNodeFromEnd.ListNode() | 0 | new RemoveNthNodeFromEnd.ListNode()
        createListNode([1, 2])              | 1 | createListNode([1])
        createListNode([1, 2])              | 2 | createListNode([2])
        createListNode([1, 2, 3])           | 0 | createListNode([1, 2, 3])
    }

    def createListNode(List<Integer> nodes) {
        def head = new RemoveNthNodeFromEnd.ListNode(nodes.remove(0))
        if (nodes.size() != 0) {
            def next = new RemoveNthNodeFromEnd.ListNode()
            head.next = next
            for (int i = 0; i < nodes.size(); i++) {
                next.val = nodes.get(i)
                if (i != nodes.size() - 1) {
                    next.next = new RemoveNthNodeFromEnd.ListNode()
                    next = next.next
                }
            }
        }
        return head
    }
}
