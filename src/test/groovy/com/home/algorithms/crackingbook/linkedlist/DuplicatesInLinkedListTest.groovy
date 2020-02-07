package com.home.algorithms.crackingbook.linkedlist

import spock.lang.Specification

class DuplicatesInLinkedListTest extends Specification {

    DuplicatesInLinkedList duplicatesInLinkedList = new DuplicatesInLinkedList()

    def 'test remove duplicates'() {
        given: 'parameterized'
        when: 'method called'
        duplicatesInLinkedList.deleteDuplicates(node)

        then: 'verify'
        node == expected

        where: 'parameters'
        node                                            | expected
        createNode(['a', 'b', 'c', 'a', 'd'] as char[]) | createNode(['a', 'b', 'c', 'd'] as char[])
        createNode(['a', 'b', 'c', 'd', 'd'] as char[]) | createNode(['a', 'b', 'c', 'd'] as char[])
        createNode(['a', 'd', 'd', 'd', 'd'] as char[]) | createNode(['a', 'd'] as char[])
        null | null
        new LinkedListNode('a' as char) | new LinkedListNode('a' as char)
    }

    def createNode(char[] values) {
        def node = new LinkedListNode(values[0])
        def res = node;
        for (int i = 1; i < values.length; i++) {
            node.next = new LinkedListNode(values[i])
            node = node.next
        }
        return res
    }
}
