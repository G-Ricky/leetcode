package com.leetcode.solution.problem143;

import com.leetcode.ListNode;

/**
 * 重排链表
 *
 * @author Ricky
 * @date 2020-10-20 23:44:19
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 寻找中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null;
        ListNode next;
        // fast == null 时为偶数个节点，否则为奇数个节点
        ListNode node = slow.next;
        ListNode part2 = slow.next;
        slow.next = null;
        // 反转后半段
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        // 合并链表
        ListNode node1 = head;
        ListNode node2 = prev;
        while (node2 != null) {
            ListNode next2 = node2.next;
            node2.next = node1.next;
            node1.next = node2;
            node2 = next2;
            node1 = node1.next.next;
        }
    }
}
