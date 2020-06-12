package com.leetcode.problem102;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ricky
 * @date 2020-06-11 23:17:37
 */
public class BfsSolution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

        }

        return null;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}