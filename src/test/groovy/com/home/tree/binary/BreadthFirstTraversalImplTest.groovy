package com.home.tree.binary

import spock.lang.Specification

class BreadthFirstTraversalImplTest extends Specification {

    BreadthFirstTraversalImpl traversalImpl = new BreadthFirstTraversalImpl()

    def 'test level-order traversal'() {
        given: 'a tree'
        Node root = createTree()

        when: 'level-order traversal called'
        def res = traversalImpl.traverseLevelOrder(root)

        then: 'check expected order'
        res == "abcdefghi"
    }


    def 'test calculate depth'() {
        given: 'a tree'
        def root = createTree()

        when: 'calculate depth'
        def depth = traversalImpl.calculateDepth(root)

        then: 'expect 4'
        depth == 4
    }

/*
                 a
          b              c
      d      e               f
           g   h          i
*/
    def createTree() {
        def root = new Node("a")
        def b = new Node("b")
        def c = new Node("c")
        root.left = b
        root.right = c
        def d = new Node("d")
        def e = new Node("e")
        def f = new Node("f")
        b.left = d
        b.right = e
        c.right = f
        def g = new Node("g")
        def h = new Node("h")
        def i = new Node("i")
        e.left = g
        e.right = h
        f.left = i
        return root
    }

}
