package com.leetcode.problem236;

import java.util.Stack;

/**
 * 二叉树的最近公共祖先
 *
 * @author Ricky
 * @date 2020-06-08 00:41:35
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left == null
            ? right
            : right == null
                ? left
                : root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
