package com.home.tree.nodesLinked

import spock.lang.Specification

class TreeNodeLinkerTest extends Specification {

    TreeNodeLinker treeNodeLinker = new TreeNodeLinker()

    def 'test level-order traversal with links'() {
        given: 'a tree with left and right links'
        def root = createNodesWithLRLinks()

        and: 'expected tree with left, right, next links'
        def expected = createNodesWithLRNLinks()

        when: 'link nodes called'
        def res = treeNodeLinker.linkNodes(root)

        then: 'check'
        res == expected
    }

/*
                 a
          b              c
      d      e               f
           g   h          i
*/
    def createNodesWithLRLinks() {
        def root = new LinkedNode("a")
        def b = new LinkedNode("b")
        def c = new LinkedNode("c")
        root.left = b
        root.right = c
        def d = new LinkedNode("d")
        def e = new LinkedNode("e")
        def f = new LinkedNode("f")
        b.left = d
        b.right = e
        c.right = f
        def g = new LinkedNode("g")
        def h = new LinkedNode("h")
        def i = new LinkedNode("i")
        e.left = g
        e.right = h
        f.left = i
        return root
    }

    def createNodesWithLRNLinks() {
        def root = new LinkedNode("a")
        def b = new LinkedNode("b")
        def c = new LinkedNode("c")
        b.next = c
        root.left = b
        root.right = c
        def d = new LinkedNode("d")
        def e = new LinkedNode("e")
        def f = new LinkedNode("f")
        d.next = e
        e.next = f
        b.left = d
        b.right = e
        c.right = f
        def g = new LinkedNode("g")
        def h = new LinkedNode("h")
        def i = new LinkedNode("i")
        e.left = g
        e.right = h
        f.left = i
        g.next = h
        h.next = i
        return root
    }
}
