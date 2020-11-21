package com.leetcode.solution.problem148;

import com.leetcode.ListNode;

/**
 * @author Ricky
 * @date 2020-11-21 23:24:31
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode start) {
        if (start == null || start.next == null) {
            return start;
        }
        ListNode fast = start;
        ListNode slow = start;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        ListNode left = mergeSort(start);
        ListNode right = mergeSort(slow);
        return link(left, right);
    }

    private ListNode link(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        ListNode node = left;
        ListNode prev = null;
        outer:
        while (right != null) {
            while (node.val <= right.val) {
                prev = node;
                node = node.next;
                if (node == null) {
                    prev.next = right;
                    break outer;
                }
            }
            ListNode newRight = right.next;
            if (prev == null) {
                right.next = left;
                left = right;
                right = newRight;
                prev = left;
            } else {
                right.next = prev.next;
                prev.next = right;
                right = newRight;
                prev = prev.next;
            }
        }
        return left;
    }
}
