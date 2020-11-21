package com.leetcode.solution.problem148;

import com.leetcode.ListNode;

/**
 * 排序链表
 *
 * @author Ricky
 * @date 2020-11-21 01:56:50
 */
public class QuickSortSolution {
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        quickSort(dummy, null);
        return dummy.next;
    }

    private void quickSort(ListNode start, ListNode end) {
        if (start.next == end) {
            return;
        }
        ListNode base = start.next;
        ListNode prev = base;
        ListNode node = prev.next;
        while (node != end) {
            if (node.val < base.val) {
                prev.next = node.next;
                node.next = start.next;
                start.next = node;
                node = prev.next;
            } else {
                prev = node;
                node = node.next;
            }
        }
        quickSort(start, base);
        quickSort(base, end);
    }
}
