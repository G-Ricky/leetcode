package com.leetcode.solution.problem2;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        ListNode last = res;

        while (true) {
            if (l1 != null && l2 != null) {
                curr.val += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                curr.val += l1.val;
                l1 = l1.next;
            } else if (l2 != null) {
                curr.val += l2.val;
                l2 = l2.next;
            } else {
                break;
            }
            curr.next = new ListNode(curr.val / 10); // 进位
            curr.val %= 10;
            last = curr;
            curr = curr.next;
        }

        if (last.next != null && last.next.val == 0) {
            last.next = null;
        }

        return res;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
