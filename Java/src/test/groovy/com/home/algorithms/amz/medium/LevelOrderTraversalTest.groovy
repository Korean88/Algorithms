package com.home.algorithms.amz.medium

import com.home.algorithms.amz.model.BinaryTree
import spock.lang.Specification

class LevelOrderTraversalTest extends Specification {

    def instance = new LevelOrderTraversal()

    def 'test merge iterative'() {
        given: 'parameterized test'
        when: 'method called'
        def root = BinaryTree.createFromList(input)
        def res = instance.levelOrder(root)

        then: 'verify'
        res == expected

        where: 'parameters'
        input                                          | expected
        [3, 9, 20, null, null, 15, 7]                  | [[3], [9, 20], [15, 7]]
        [1]                                            | [[1]]
        []                                             | []
        [3, 9, 20, 1, null, null, 7, null, 2, null, 4] | [[3], [9, 20], [1, 7], [2, 4]]
    }
}
