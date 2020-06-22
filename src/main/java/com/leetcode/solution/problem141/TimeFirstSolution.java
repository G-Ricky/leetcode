package com.leetcode.solution.problem141;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 *
 * @author Ricky
 * @date 2020-06-06 20:53:15
 */
public class TimeFirstSolution {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> nodes = new HashSet<>();

        while (head != null) {
            if (nodes.contains(head)) {
                return true;
            }
            nodes.add(head);
            head = head.next;
        }

        return false;
    }
}
