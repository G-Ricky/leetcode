package com.leetcode.solution.problem2;

import com.leetcode.ListNode;

/**
 * 两数相加
 *
 * @author Ricky
 * @date 2020-10-04 20:28:07
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode root = null;
        ListNode node = null;
        ListNode prev = null;
        while (l1 != null || l2 != null) {
            node = new ListNode();
            if (root == null) {
                root = node;
            }
            if (prev != null) {
                prev.next = node;
            }
            if (l1 != null) {
                node.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                node.val += l2.val;
                l2 = l2.next;
            }
            node.val += carry;
            carry = node.val / 10;
            node.val %= 10;
            prev = node;
        }
        if (carry > 0) {
            node.next = new ListNode(carry);
        }
        return root;
    }
}
