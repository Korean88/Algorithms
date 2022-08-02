package com.home.algorithms.goldmansachs.tree

import spock.lang.Specification

class FlattenLinkedListTest extends Specification {

    FlattenLinkedList flattenLinkedList = new FlattenLinkedList()

    def 'test vertical flattening'() {
        given: '2-dim linked list'
        def root = new FlattenLinkedList.Node(5)
        root.down = new FlattenLinkedList.Node(7)
        root.down.down = new FlattenLinkedList.Node(8)
        root.down.down.down = new FlattenLinkedList.Node(30)

        root.right = new FlattenLinkedList.Node(10)
        root.right.down = new FlattenLinkedList.Node(20)

        root.right.right = new FlattenLinkedList.Node(19)
        root.right.right.down = new FlattenLinkedList.Node(22)
        root.right.right.down.down = new FlattenLinkedList.Node(50)

        root.right.right.right = new FlattenLinkedList.Node(28)
        root.right.right.right.down = new FlattenLinkedList.Node(35)
        root.right.right.right.down.down = new FlattenLinkedList.Node(40)
        root.right.right.right.down.down.down = new FlattenLinkedList.Node(45)

        when: 'method called'
        def res = flattenLinkedList.flattenVertically(root)

        then: 'verify nodes'
        res.right == null
        res.value == 5
        res.down.value == 7
        res.down.down.value == 8
        res.down.down.down.value == 10
        res.down.down.down.down.value == 19
        res.down.down.down.down.down.value == 20
    }
}
