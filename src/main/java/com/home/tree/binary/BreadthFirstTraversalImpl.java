package com.home.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraversalImpl {

    String traverseLevelOrder(Node root) {
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            sb.append(current.value);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return sb.toString();
    }

    int calculateDepth(Node node) {
        int res = 0;
        //check if node != null
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    res++;
                } else {
                    res++;
                }
            } else {
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return res;
    }

}
