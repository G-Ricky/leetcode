package com.leetcode.solution.interview0201;

import com.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 移除重复节点
 *
 * @author Ricky
 * @date 2020-06-26 17:47:33
 */
public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();

        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            if (set.contains(node.val)) {
                prev.next = node.next;
                node.next = null;
                node = prev.next;
            } else {
                set.add(node.val);
                prev = node;
                node = node.next;
            }
        }

        return head;
    }
}
