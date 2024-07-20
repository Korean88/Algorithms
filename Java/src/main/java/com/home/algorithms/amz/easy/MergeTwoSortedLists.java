package com.home.algorithms.amz.easy;

import com.home.algorithms.leetcode.listnode.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeIterative(ListNode listNode1, ListNode listNode2) {
        ListNode current = new ListNode(0);
        ListNode dummyHead = current;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.getVal() < listNode2.getVal()) {
                current.setNext(listNode1);
                listNode1 = listNode1.getNext();
            } else {
                current.setNext(listNode2);
                listNode2 = listNode2.getNext();
            }
            current = current.getNext();
        }
        if (listNode1 == null) {
            current.setNext(listNode2);
        } else {
            current.setNext(listNode1);
        }
        return dummyHead.getNext();
    }

    public ListNode mergeRecursive(ListNode listNode1, ListNode listNode2) {
        if (listNode1 != null && listNode2 != null) {
            if (listNode1.getVal() < listNode2.getVal()) {
                listNode1.setNext(mergeRecursive(listNode1.getNext(), listNode2));
                return listNode1;
            } else {
                listNode2.setNext(mergeRecursive(listNode1, listNode2.getNext()));
                return listNode2;
            }
        } else if (listNode1 != null) {
            return listNode1;
        } else {
            return listNode2;
        }
    }


}
