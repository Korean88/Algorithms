package com.home.algorithms.leetcode.listnode;

import java.util.*;
import java.util.stream.Collectors;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        List<ListNode> filtered = Arrays.stream(lists)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        for (ListNode listNode : filtered) {
            ListNode currenListNode = listNode;
            if (currenListNode != null) {
                list.add(currenListNode.val);
                while (currenListNode.next != null) {
                    currenListNode = currenListNode.next;
                    list.add(currenListNode.val);
                }
            }
        }
        ListNode head = null;
        if (list.size() > 0) {
            Collections.sort(list);
            head = new ListNode(list.get(0));
            if (list.size() > 1) {
                ListNode pointer = head;
                for (int i = 1; i < list.size(); i++) {
                    pointer.next = new ListNode(list.get(i));
                    pointer = pointer.next;
                }
            }
        }
        return head;
    }

}
