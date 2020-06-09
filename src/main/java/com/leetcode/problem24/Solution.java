package com.leetcode.problem24;

/**
 * 两两交换链表中的节点
 *
 * @author Ricky
 * @date 2020-06-06 20:04:40
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode last = null;
        if (current.next != null) {
            head = current.next;
        }
        while (current != null && current.next != null) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = current;
            if (last != null) {
                last.next = next;
            }
            last = current;
            current = current.next;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}