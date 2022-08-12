package com.home.algorithms.leetcode.listnode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPairs {

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
