package com.home.algorithms.crackingbook.linkedlist;

public class DuplicatesInLinkedList {
    void deleteDuplicates(LinkedListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        LinkedListNode listNode = node;
        while (listNode != null) {
            LinkedListNode another = listNode;
            while (another.next != null) {
                if (listNode.value == another.next.value) {
                    another.next = another.next.next;
                } else {
                    another = another.next;
                }
            }
            listNode = listNode.next;
        }
    }
}
