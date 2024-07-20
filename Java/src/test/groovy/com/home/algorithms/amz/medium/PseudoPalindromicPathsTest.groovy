package com.home.algorithms.amz.medium

import com.home.algorithms.amz.model.BinaryTree
import spock.lang.Specification

class PseudoPalindromicPathsTest extends Specification {

    def instance = new PseudoPalindromicPaths()

    def 'test validate bst'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.pseudoPalindromicPaths(root)

        then: 'verify'
        res == expected

        where: 'parameters'
        root                                                                                             | expected
        BinaryTree.createFromList([2, 3, 1, 3, 1, null, 1])                                              | 2
        BinaryTree.createFromList([2, 1, 1, 1, 3, null, null, null, null, null, 1])                      | 1
        BinaryTree.createFromList([8, 6, 9, null, null, null, 4, 4, 1, 5, 4, null, null, null, null, 8]) | 0
    }
}
