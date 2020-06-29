package com.leetcode.solution.problem142;

import com.leetcode.ListNode;

/**
 * @author Ricky
 * @date 2020-06-30 00:54:59
 */
@SuppressWarnings("DuplicatedCode")
public class FloydSolution {
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
        ListNode cursor = head;

        while (meet != cursor) {
            meet = meet.next;
            cursor = cursor.next;
        }

        return meet;
    }
}
