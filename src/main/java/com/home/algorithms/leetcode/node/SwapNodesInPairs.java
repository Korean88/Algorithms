package com.home.algorithms.leetcode.node;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }

        public String toString() {
            ListNode ln = this;
            StringBuilder sb = new StringBuilder("[");
            while (ln != null) {
                sb.append(ln.val).append(",");
                ln = ln.next;
            }
            return sb.replace(sb.length() - 1, sb.length(), "").append("]").toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        Queue<ListNode> queue = new LinkedList<>();
        while (head != null) {
            queue.add(head);
            head = head.next;
        }
        if (queue.size() == 1) return queue.poll();

        ListNode first = queue.poll();
        ListNode second = queue.poll();
        ListNode resHead = second;
        resHead.next = first;
        resHead.next.next = null;
        ListNode pointer = resHead.next;
        while (!queue.isEmpty()) {
            first = queue.poll();
            second = queue.poll();
            if (second != null) {
                pointer.next = second;
                pointer.next.next = first;
                pointer = pointer.next.next;
                pointer.next = null;
            } else {
                pointer.next = first;
                pointer.next.next = null;
            }
        }
        return resHead;
    }
}
