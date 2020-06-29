package com.leetcode.utils;

import com.leetcode.ListNode;

/**
 * 链表节点操作工具
 *
 * @author Ricky
 * @date 2020-06-30 01:03:19
 */
public class ListNodeUtils {

    /**
     * 连接相邻两个链表节点，下标小的节点为下标大的节点的前驱节点
     *
     * @param nodes 数组形式的节点列表
     * @param beginIndex 开始下标
     * @param endIndex 结束下标（不包含）
     * @return 头节点
     */
    public static ListNode link(ListNode[] nodes, int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            throw new IndexOutOfBoundsException("超出数组下界");
        }
        if (endIndex > nodes.length) {
            throw new IndexOutOfBoundsException("超出数组上界");
        }
        if (beginIndex >= endIndex) {
            throw new IllegalArgumentException("开始下标必须小于结束下标");
        }

        for (int i = beginIndex + 1; i < endIndex; ++i) {
            nodes[i - 1].next = nodes[i];
        }

        return nodes[beginIndex];
    }
}
