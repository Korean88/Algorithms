package com.home.tree.nodesLinked;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeLinker {

    LinkedNode linkNodes(LinkedNode root) {
        Queue<LinkedNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            LinkedNode current = queue.poll();
            if (current != null) {
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
                current.next = queue.peek();
            } else {
                if (!queue.isEmpty()) queue.add(null);
            }
        }
        return root;
    }
}
