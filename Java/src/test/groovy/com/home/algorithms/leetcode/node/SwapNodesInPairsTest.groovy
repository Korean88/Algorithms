package com.home.algorithms.leetcode.node


import spock.lang.Specification

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
//        createListNode([1, 2, 3, 4] as int[]) | createListNode([2, 1, 4, 3] as int[])
//        createListNode([1, 2, 3] as int[]) | createListNode([2, 1, 3] as int[])
//        createListNode([1] as int[]) | createListNode([1] as int[])
        createListNode([1,2] as int[]) | createListNode([2,1] as int[])
    }

    def createListNode(int[] array) {
        SwapNodesInPairs.ListNode head = new SwapNodesInPairs.ListNode(array[0])
        if (array.length > 1) {
            SwapNodesInPairs.ListNode pointerHead = head
            for (int i = 1; i < array.length; i++) {
                pointerHead.next = new SwapNodesInPairs.ListNode(array[i])
                pointerHead = pointerHead.next
            }
        }
        return head
    }

}