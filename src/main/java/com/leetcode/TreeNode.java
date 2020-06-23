package com.leetcode;

import java.util.Objects;

/**
 * @author Ricky
 * @date 2020-06-16 00:52:16
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return treeEquals(this, (TreeNode) o);
    }

    @Override
    public int hashCode() {
        return nodeHash(this);
    }

    private boolean treeEquals(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p == null && q != null || p != null && q == null) {
            return false;
        }

        // TODO 树成环报错
        return p.val == q.val && treeEquals(p.left, q.left) && treeEquals(p.right, q.right);
    }

    private int nodeHash(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // TODO 树成环报错
        return Objects.hash(node.val, nodeHash(node.left), nodeHash(node.right));
    }
}
