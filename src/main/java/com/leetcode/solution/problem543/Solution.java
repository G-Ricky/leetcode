package com.leetcode.solution.problem543;

class Solution {

    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        treeDepth(root);
        return maxDiameter;
    }

    private int treeDepth(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int left = treeDepth(node.left) + 1;
        int right = treeDepth(node.right) + 1;

        maxDiameter = Math.max(maxDiameter, left + right);

        return Math.max(left, right);
    }
}