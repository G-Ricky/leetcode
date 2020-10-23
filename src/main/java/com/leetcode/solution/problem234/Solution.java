package com.leetcode.solution.problem234;

import com.leetcode.ListNode;

/**
 * 回文链表
 *
 * @author Ricky
 * @date 2020-10-23 13:52:31
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 奇数个节点
        if (fast != null) {
            slow = slow.next;
        }
        ListNode node = slow;
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        while (prev != null) {
            if (prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}
