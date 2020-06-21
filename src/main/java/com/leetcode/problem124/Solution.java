package com.leetcode.problem124;

import com.leetcode.TreeNode;
import com.leetcode.problem297.Codec;

/**
 * 二叉树中的最大路径和
 * 注：单独一个节点为一个“路径”
 *
 * @author Ricky
 * @date 2020-06-21 17:52:40
 */
public class Solution {
    // 局部最大值
    private int maxPart = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPart = Integer.MIN_VALUE;
        return Math.max(getMaxPathSum(root), maxPart);
    }

    private int getMaxPathSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        maxPart = Math.max(maxPart, root.val);
        if (root.left == null && root.right == null) {
            // 如果单独一个节点为一个“路径”时返回 root.val
            // 如果单独一个节点不为一个“路径”返回 Integer.MIN_VALUE
            return root.val;
        }
        int maxLeft = root.left != null
            ? Math.max(getMaxPathSum(root.left), root.left.val)
            : Integer.MIN_VALUE;

        int maxRight = root.right != null
            ? Math.max(getMaxPathSum(root.right), root.right.val)
            : Integer.MIN_VALUE;

        if (root.left != null && root.right != null) {
            maxPart = Math.max(maxPart, maxLeft + maxRight + root.val);
            return Math.max(maxLeft, maxRight) + root.val;
        }

        if (root.left != null) {
            maxPart = Math.max(maxPart, maxLeft);
            maxPart = Math.max(maxPart, maxLeft + root.val);
            return Math.max(maxLeft + root.val, root.val);
        } else { // root.right != null
            maxPart = Math.max(maxPart, maxRight);
            maxPart = Math.max(maxPart, maxRight + root.val);
            return Math.max(maxRight + root.val, root.val);
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution solution = new Solution();

        System.out.println(solution.maxPathSum(codec.deserialize("[-4,-5,4,5,null,3,null,-2,null,6,null,null,null,2,-2]")));
        System.out.println(solution.maxPathSum(codec.deserialize("[0]")));
        System.out.println(solution.maxPathSum(codec.deserialize("[2,-1]")));
        System.out.println(solution.maxPathSum(codec.deserialize("[-2,1]")));
        System.out.println(solution.maxPathSum(codec.deserialize("[2,-1,-2]")));
        System.out.println(solution.maxPathSum(codec.deserialize("[1,2,3]")));
        System.out.println(solution.maxPathSum(codec.deserialize("[-10,9,20,null,null,15,7]")));
        System.out.println(solution.maxPathSum(codec.deserialize("[1,1,1,1,1,1,1,1,1,1,1,100,100,1,1]")));
    }
}
