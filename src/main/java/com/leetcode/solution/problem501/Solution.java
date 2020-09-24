package com.leetcode.solution.problem501;

import com.leetcode.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 二叉搜索树中的众数
 *
 * @author Ricky
 * @date 2020-09-24 22:15:14
 */
public class Solution {

    private Set<Integer> maxNodes = new HashSet<>();

    private int maxCount = Integer.MIN_VALUE;

    private Integer prev = null;

    private int count = 1;

    public int[] findMode(TreeNode root) {
        findNode(root);
        int[] result = new int[maxNodes.size()];
        int i = 0;
        for (Integer val : maxNodes) {
            result[i++] = val;
        }
        return result;
    }

    private void findNode(TreeNode node) {
        if (node == null) {
            return;
        }
        findNode(node.left);
        if (prev != null) {
            if (node.val == prev) {
                ++count;
            } else {
                count = 1;
            }
        }
        update(maxCount, count, node.val);
        prev = node.val;
        findNode(node.right);
    }

    private void update(int oldMax, int newMax, int val) {
        if (newMax > oldMax) {
            maxCount = newMax;
            maxNodes.clear();
            maxNodes.add(val);
        } else if (newMax == oldMax) {
            maxCount = newMax;
            maxNodes.add(val);
        }
    }
}
