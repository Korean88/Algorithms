package com.home.algorithms.leetcode.listnode

class ListNodeUtils {

    static def createListNode(int[] array) {
        ListNode head = new ListNode(array[0])
        if (array.length > 1) {
            ListNode pointerHead = head
            for (int i = 1; i < array.length; i++) {
                pointerHead.next = new ListNode(array[i])
                pointerHead = pointerHead.next
            }
        }
        return head
    }

    static def createListNodes(List<List<Integer>> lists) {
        List<ListNode> resList = new ArrayList<>()
        for (List<Integer> l : lists) {
            def node = createListNode(l)
            if (node != null) {
                resList.add(node)
            }
        }
        return resList.toArray(new ListNode[0])
    }

    static def createListNode(List<Integer> integers) {
        def res = null
        if (integers != null && integers.size() != 0) {
            ListNode head = new ListNode(integers[0])
            if (integers.size() > 1) {
                ListNode pointer = head
                for (int i = 1; i < integers.size(); i++) {
                    pointer.next = new ListNode(integers[i])
                    pointer = pointer.next
                }
            }
            res = head
        }
        return res
    }

}
