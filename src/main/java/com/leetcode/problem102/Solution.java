package com.leetcode.problem102;

import java.util.*;

/**
 * 二叉树的层序遍历
 *
 * @author Ricky
 * @date 2020-06-11 23:04:02
 */
public class Solution {

    Map<Integer, List<Integer>> result = new LinkedHashMap<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);

        List<List<Integer>> ans = new LinkedList<>();
        for (Map.Entry<Integer, List<Integer>> entry : result.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        result.computeIfAbsent(level, (k) -> new LinkedList<>()).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
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