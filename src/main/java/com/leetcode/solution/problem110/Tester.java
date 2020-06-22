package com.leetcode.solution.problem110;

public class Tester {

    public static void test() {
        TreeNode root1 = new TreeNode(3);
        TreeNode node11 = new TreeNode(9);
        TreeNode node12 = new TreeNode(20);
        TreeNode node13 = new TreeNode(15);
        TreeNode node14 = new TreeNode(7);
        root1.left = node11;
        root1.right = node12;
        node12.left = node13;
        node12.right = node14;

        TreeNode root2 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(3);
        TreeNode node24 = new TreeNode(3);
        TreeNode node25 = new TreeNode(4);
        TreeNode node26 = new TreeNode(4);
        root2.left = node21;
        root2.right = node22;
        node21.left = node23;
        node21.right = node24;
        node23.left = node25;
        node23.right = node26;

        Solution solution = new Solution();
        assert solution.isBalanced(root1);
        assert !solution.isBalanced(root2);
    }
}
