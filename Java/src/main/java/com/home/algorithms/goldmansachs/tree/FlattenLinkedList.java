package com.home.algorithms.goldmansachs.tree;

public class FlattenLinkedList {

    static class Node {
        Node right;
        Node down;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    Node flattenVertically(Node root) {
        while (root.right != null) {
            root = mergeVerticalLists(root, root.right);
            root.right=root.right.right;
        }
        return root;
    }

    private Node mergeVerticalLists(Node n1, Node n2) {
        if (n1==null) return n2;
        if (n2==null) return n1;

        Node res;
        if (n1.value < n2.value) {
            res = n1;
            res.down = mergeVerticalLists(n2, n1.down);
        } else {
            res = n2;
            res.down = mergeVerticalLists(n1, n2.down);
        }
        return res;
    }


}
