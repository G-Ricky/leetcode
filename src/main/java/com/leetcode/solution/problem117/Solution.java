package com.leetcode.solution.problem117;

import com.leetcode.Node;

/**
 * 填充每个节点的下一个右侧节点指针 II
 *
 * @author Ricky
 * @date 2020-09-28 23:31:28
 */
public class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node node = root;
        while (node != null) {
            Node nextHead = null;
            Node nextTail = null;
            while (node != null) {
                // 下一层未定义头尾指针
                if (nextHead == null) {
                    if (node.left != null) {
                        nextTail = nextHead = node.left;
                        if (node.right != null) {
                            nextTail.next = node.right;
                            nextTail = node.right;
                            node = node.next;
                            continue;
                        }
                    } else if (node.right != null) {
                        nextTail = nextHead = node.right;
                        node = node.next;
                        continue;
                    }
                // 下一层已定义头尾指针
                } else {
                    if (node.left != null) {
                        nextTail.next = node.left;
                        nextTail = node.left;
                    }
                    if (node.right != null) {
                        nextTail.next = node.right;
                        nextTail = node.right;
                    }
                }
                node = node.next;
            }
            node = nextHead;
        }
        return root;
    }
}
