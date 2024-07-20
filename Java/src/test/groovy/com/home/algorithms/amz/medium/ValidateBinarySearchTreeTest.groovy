package com.home.algorithms.amz.medium

import com.home.algorithms.amz.model.BinaryTree
import spock.lang.Specification

class ValidateBinarySearchTreeTest extends Specification {
    def instance = new ValidateBinarySearchTree()

    def 'test iterative approach with stack'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.isValidBST(BinaryTree.createFromList(input))

        then: 'verify'
        res == expected

        where: 'parameters'
        input                                                               | expected
        [2, 1, 3]                                                           | true
        [5, 1, 4, null, null, 3, 6]                                         | false
        [100, 50, null, 25, 75, null, 27, 70, 80, null, null, null, 72, 79] | true
        [79]                                                                | true
        [34, -6, null, -21]                                                 | true
    }

    def 'test recursive approach'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.recursive(BinaryTree.createFromList(input))

        then: 'verify'
        res == expected

        where: 'parameters'
        input                                                               | expected
        [2, 1, 3]                                                           | true
        [5, 1, 4, null, null, 3, 6]                                         | false
        [100, 50, null, 25, 75, null, 27, 70, 80, null, null, null, 72, 79] | true
        [79]                                                                | true
        [34, -6, null, -21]                                                 | true
    }
}
