package com.leetcode.solution.problem173;

import com.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树迭代器
 *
 * @author Ricky
 * @date 2021-03-28 01:03:36
 */
class BSTIterator {

    private final TreeNode root;

    private final Deque<TreeNode> nodeStack;

    /**
     * 子节点访问标记
     * 0 未访问子节点，1 已访问左节点，2 已访问右节点
     */
    private final Deque<Integer> flagStack;

    private Boolean hasNext = null;

    private TreeNode next = null;

    public BSTIterator(TreeNode root) {
        this.root = root;
        this.nodeStack = new LinkedList<>();
        this.flagStack = new LinkedList<>();
        nodeStack.push(root);
        flagStack.push(0);
    }

    public int next() {
        if (this.hasNext == null) {
            getNext();
        }
        TreeNode next = this.next;
        this.hasNext = null;
        this.next = null;
        return next.val;
    }

    public boolean hasNext() {
        if (hasNext == null) {
            getNext();
        }
        if (hasNext == null) {
            throw new RuntimeException();
        }
        return hasNext;
    }

    private void getNext() {
        while (true) {
            if (nodeStack.isEmpty()) {
                hasNext = false;
                next = null;
                return;
            }
            TreeNode node = nodeStack.pop();
            Integer flag = flagStack.pop();
            switch (flag) {
                case 0:
                    if (node.left != null) {
                        nodeStack.push(node);
                        flagStack.push(1);
                        nodeStack.push(node.left);
                        flagStack.push(0);
                    } else if (node.right != null) {
                        nodeStack.push(node);
                        flagStack.push(2);
                        nodeStack.push(node.right);
                        flagStack.push(0);
                        hasNext = true;
                        next = node;
                        return;
                    } else {
                        hasNext = true;
                        next = node;
                        return;
                    }
                    break;
                case 1:
                    if (node.right != null) {
                        // nodeStack.push(node);
                        // flagStack.push(2);
                        nodeStack.push(node.right);
                        flagStack.push(0);
                    }
                    hasNext = true;
                    next = node;
                    return;
                default:
            }
        }
    }
}
