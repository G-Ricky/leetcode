package com.leetcode.problem110;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private boolean isBreak = false;
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        isBreak = false;
        isBalanced = true;
        tr(root);
        return isBalanced;
    }

    private int tr(TreeNode node) {
        if (node == null || isBreak) {
            return 0;
        }

        int depth1 = tr(node.left);
        int depth2 = tr(node.right);

        if (Math.abs(depth1 - depth2) > 1) {
            isBreak = true;
            isBalanced = false;
        }

        return Math.max(depth1, depth2) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}