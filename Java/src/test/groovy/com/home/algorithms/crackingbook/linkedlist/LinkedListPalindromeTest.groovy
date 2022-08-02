package com.home.algorithms.crackingbook.linkedlist

import spock.lang.Specification

class LinkedListPalindromeTest extends Specification {

    LinkedListPalindrome linkedListPalindrome = new LinkedListPalindrome()

    def 'test solution with Stack'() {
        given: 'parameterized'
        when: 'method called'
        def res = linkedListPalindrome.isPalindrome(head as LinkedListNode)

        then: 'verify'
        res == expected

        where: 'parameters'
        head                                                           | expected
        createNode(['a', 'b', 'c', 'c', 'b', 'a'] as char[])           | true
        createNode(['a', 'b', 'c', '1', 'c', 'b', 'a'] as char[])      | true
        createNode(['a', 'b', 'c', '1', 'f', 'c', 'b', 'a'] as char[]) | false
        createNode(['a', 'a'] as char[])                               | true
        createNode(['a', 'b'] as char[])                               | false
        createNode(['a'] as char[])                                    | true
        null                                                           | false
    }

    def createNode(char[] values) {
        def node = new LinkedListNode(values[0])
        def res = node
        for (int i = 1; i < values.length; i++) {
            node.next = new LinkedListNode(values[i])
            node = node.next
        }
        return res
    }
}
