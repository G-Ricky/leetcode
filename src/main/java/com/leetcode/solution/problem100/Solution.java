package com.leetcode.solution.problem100;

import com.leetcode.TreeNode;

/**
 * 相同的树
 *
 * @author Ricky
 * @date 2020-06-24 00:19:54
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // including null == null
        if (p == q) {
            return true;
        }
        if (p == null && q != null || p != null && q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
