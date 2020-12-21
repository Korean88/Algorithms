package com.home.algorithms.goldmansachs.tree

import spock.lang.Specification

class HeightBalancedTest extends Specification {

    HeightBalanced heightBalanced = new HeightBalanced()

    def 'should return true if tree is height-balanced'() {
        given: 'a height-balanced tree'
        HeightBalanced.TreeNode root = new HeightBalanced.TreeNode()
        HeightBalanced.TreeNode left = new HeightBalanced.TreeNode()
        HeightBalanced.TreeNode right = new HeightBalanced.TreeNode()
        root.left = left
        root.right = right
        left.left = new HeightBalanced.TreeNode()
        left.right = new HeightBalanced.TreeNode()
        left.left.left = new HeightBalanced.TreeNode()
        right.left = new HeightBalanced.TreeNode()
        right.right = new HeightBalanced.TreeNode()
        right.right.right = new HeightBalanced.TreeNode()

        when: 'call method'
        def res = heightBalanced.isHeightBalanced(root)

        then: 'should be true'
        res
    }

    def 'should return false if tree is height-balanced'() {
        given: 'a non-height-balanced tree'
        HeightBalanced.TreeNode root = new HeightBalanced.TreeNode()
        HeightBalanced.TreeNode left = new HeightBalanced.TreeNode()
        HeightBalanced.TreeNode right = new HeightBalanced.TreeNode()
        root.left = left
        root.right = right
        left.left = new HeightBalanced.TreeNode()
        left.right = new HeightBalanced.TreeNode()
        left.left.left = new HeightBalanced.TreeNode()
        right.left = new HeightBalanced.TreeNode()
        right.right = new HeightBalanced.TreeNode()
        right.right.right = new HeightBalanced.TreeNode()
        right.right.right.right = new HeightBalanced.TreeNode();

        when: 'call method'
        def res = heightBalanced.isHeightBalanced(root)

        then: 'should be false'
        !res
    }
}
