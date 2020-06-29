package com.leetcode.solution.problem142;

import com.leetcode.ListNode;

/**
 * 环形链表 II
 * （比 Floyd 算法慢）
 * @author Ricky
 * @date 2020-06-30 00:53:35
 */
@SuppressWarnings("DuplicatedCode")
public class Solution {
    public ListNode detectCycle(ListNode head) {

        int step = 0;
        ListNode fast = head;
        ListNode slow = head;
        // 寻找相遇点
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            if (step != 0 && fast == slow) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
            ++step;
        }

        ListNode meet = fast;
        ListNode cursor = meet;
        int cycleSize = 0;
        while (cycleSize == 0 || cursor != meet) {
            cursor = cursor.next;
            ++cycleSize;
        }

        ListNode outer = head;
        for (int i = 0; i < step - cycleSize; ++i) {
            outer = outer.next;
        }

        while (outer != meet) {
            outer = outer.next;
            meet = meet.next;
        }

        return outer;
    }
}
