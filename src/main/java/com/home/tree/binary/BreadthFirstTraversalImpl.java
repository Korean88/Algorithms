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

}
