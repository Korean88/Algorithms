package com.home.algorithms.array.sum

import spock.lang.Specification

class ReverseIntegerSumTest extends Specification {

    def subject = new ReverseIntegerSum()

    def 'should sum up 2-digit integers with overflow'() {
        given: "75+18=93"
        ReverseIntegerSum.Node node1 = new ReverseIntegerSum.Node(5)
        ReverseIntegerSum.Node node2 = new ReverseIntegerSum.Node(7)
        node1.next = node2
        ReverseIntegerSum.Node node3 = new ReverseIntegerSum.Node(8)
        ReverseIntegerSum.Node node4 = new ReverseIntegerSum.Node(1)
        node3.next = node4

        when: "sum called"
        def sum = subject.sum(node1, node3)

        then: "assert calculation correct"
        sum.val == 3
        sum.next.val == 9
        sum.next.next == null
    }

    def 'should sum up 2-digit integers without overflow'() {
        given: "71+14=85"
        ReverseIntegerSum.Node node1 = new ReverseIntegerSum.Node(1)
        ReverseIntegerSum.Node node2 = new ReverseIntegerSum.Node(7)
        node1.next = node2
        ReverseIntegerSum.Node node3 = new ReverseIntegerSum.Node(4)
        ReverseIntegerSum.Node node4 = new ReverseIntegerSum.Node(1)
        node3.next = node4

        when: "sum called"
        def sum = subject.sum(node1, node3)

        then: "assert calculation correct"
        sum.val == 5
        sum.next.val == 8
        sum.next.next == null
    }
}
