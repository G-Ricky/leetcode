package com.leetcode.solution.problem111;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ricky
 * @date 2020-08-21 16:29:23
 */

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        outer:
        while (!queue.isEmpty()) {
            ++level;
            Queue<TreeNode> temp = levelQueue;
            levelQueue = queue;
            queue = temp;
            while (!levelQueue.isEmpty()) {
                TreeNode node = levelQueue.poll();
                if (node.left == null && node.right == null) {
                    break outer;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return level;
    }
}
