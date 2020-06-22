package com.leetcode.solution.problem206;

/**
 * @author Ricky
 * @date 2020-06-06 19:13:17
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode currentNode = head;
        ListNode last = null;
        while (currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = last;
            last = currentNode;
            currentNode = next;
        }

        return last;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
