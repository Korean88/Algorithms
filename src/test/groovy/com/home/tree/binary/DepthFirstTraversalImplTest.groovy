package com.home.tree.binary

import spock.lang.Specification

class DepthFirstTraversalImplTest extends Specification {
    /*
                    a
               b          c
             d   e      f
                      g
    */

    DepthFirstTraversalImpl traversalImpl = new DepthFirstTraversalImpl()

    def 'test in-order traversal'() {
        given: 'a tree'
        def root = createTree()
        def sb = new StringBuilder()

        when: 'traverse in-order'
        traversalImpl.inOrder(sb, root)

        then: 'expect left-root-right traversal'
        sb.toString() == "dbeagfc"
    }

    def 'test pre-order traversal'() {
        given: 'a tree'
        def root = createTree()
        def sb = new StringBuilder()

        when: 'traverse pre-order'
        traversalImpl.preOrder(sb, root)

        then: 'expect root-left-right traversal'
        sb.toString() == "abdecfg"
    }

    def 'test post-order traversal'() {
        given: 'a tree'
        def root = createTree()
        def sb = new StringBuilder()

        when: 'traverse post-order'
        traversalImpl.postOrder(sb, root)

        then: 'expect left-right-root traversal'
        sb.toString() == "debgfca"
    }

    def createTree() {
        def root = new Node("a")
        root.left = new Node("b")
        root.right = new Node("c")
        root.left.left = new Node("d")
        root.left.right = new Node("e")
        root.right.left = new Node("f")
        root.right.left.left = new Node("g")
        return root
    }
}
