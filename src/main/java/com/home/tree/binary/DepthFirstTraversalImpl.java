package com.home.tree.binary;

public class DepthFirstTraversalImpl {

    void inOrder(StringBuilder accumulator, Node node) {
        if (node == null) {
            return;
        }
        inOrder(accumulator, node.left);
        accumulator.append(node.value);
        inOrder(accumulator, node.right);
    }

    void preOrder(StringBuilder accumulator, Node node) {
        if (node == null) {
            return;
        }
        accumulator.append(node.value);
        preOrder(accumulator, node.left);
        preOrder(accumulator, node.right);
    }

    void postOrder(StringBuilder accumulator, Node node) {
        if (node == null) {
            return;
        }
        postOrder(accumulator, node.left);
        postOrder(accumulator, node.right);
        accumulator.append(node.value);
    }
}
