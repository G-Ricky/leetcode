package com.leetcode.solution.problem141;

/**
 * 环形链表
 *
 * @author Ricky
 * @date 2020-06-06 21:00:03
 */
public class SpaceFirstSolution {

    public boolean hasCycle(ListNode head) {
        int i = 0;
        ListNode slowPointer = head;
        while (head != null) {
            if (i % 2 == 1) {
                if (head == slowPointer) {
                    return true;
                }
                slowPointer = slowPointer.next;
            }
            head = head.next;
            ++i;
        }

        return false;
    }
}
