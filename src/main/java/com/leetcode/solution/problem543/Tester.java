package com.leetcode.solution.problem543;

public class Tester {

    public static void test() {
        Solution solution = new Solution();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        assert solution.diameterOfBinaryTree(node1) == 3;
    }
}
