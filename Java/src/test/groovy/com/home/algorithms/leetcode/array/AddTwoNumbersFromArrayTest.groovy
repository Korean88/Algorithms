package com.home.algorithms.leetcode.array

import spock.lang.Specification

class AddTwoNumbersFromArrayTest extends Specification {

    AddTwoNumbersFromArray addTwoNumbersFromArray = new AddTwoNumbersFromArray()

    def 'test brute force'() {
        given: 'ListNode1 and ListNode2'

        when: 'method called'
        def res = addTwoNumbersFromArray.addTwoNumbersBruteForce(l1, l2)

        then: 'expected result'
        res == expected

        where: 'parameters'
        l1            |      l2         |    expected
        create(2,4,3) | create(5, 6, 4) | create(7, 0, 8)
        create(7,7,7) | create(3,2,2) | create(0, 0, 0, 1)
        create(0) | create(0) | create(0)
    }

    def 'test smart'() {
        given: 'ListNode1 and ListNode2'

        when: 'method called'
        def res = addTwoNumbersFromArray.addTwoNumbers(l1, l2)

        then: 'expected result'
        res == expected

        where: 'parameters'
        l1            |      l2         |    expected
        create(2,4,3) | create(5, 6, 4) | create(7, 0, 8)
        create(7,7,7) | create(3,2,2) | create(0, 0, 0, 1)
        create(7,7,7,8) | create(7,8,9) | create(4,6,7,9)
        create(9,2,3) | create(1,2,3,4) | create(0,5,6,4)
        create(0) | create(0) | create(0)
    }

    def create(int ... vals) {
        AddTwoNumbersFromArray.ListNode listNode = new AddTwoNumbersFromArray.ListNode(vals[0])
        def first = listNode
        for (int i=1; i<vals.length; i++) {
            listNode.next = new AddTwoNumbersFromArray.ListNode(vals[i])
            listNode = listNode.next
        }
        return first
    }
}
