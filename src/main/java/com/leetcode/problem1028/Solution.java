package com.leetcode.problem1028;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从先序遍历还原二叉树
 *
 * @author Ricky
 * @date 2020-06-18 22:14:35
 */
class Solution {

    public TreeNode recoverFromPreorder(String S) {
        if (S.length() == 0) {
            return null;
        }

        int i = 0;
        char[] buffer = new char[11];
        while (i < S.length() && Character.isDigit(S.charAt(i))) {
            buffer[i] = S.charAt(i);
            ++i;
        }

        int rootVal = Integer.parseInt(new String(buffer, 0, i));

        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        nodeMap.put(0, new TreeNode(rootVal));

        while (i < S.length()) {
            int level = 0;
            while (S.charAt(i) == '-') {
                ++level;
                ++i;
            }

            int count = 0;
            while (i < S.length() && Character.isDigit(S.charAt(i))) {
                buffer[count++] = S.charAt(i++);
            }
            int val = Integer.parseInt(new String(buffer, 0, count));
            TreeNode parent = nodeMap.get(level - 1);
            TreeNode node = new TreeNode(val);
            if (parent.left == null) {
                parent.left = node;
            } else if (parent.right == null) {
                parent.right = node;
            }
            nodeMap.put(level, node);
        }

        return nodeMap.get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recoverFromPreorder("3");
        solution.recoverFromPreorder("1-2--3--4-5--6--7");
        solution.recoverFromPreorder("1-2--3---4-5--6---7");
        solution.recoverFromPreorder("1-401--349---90--88");
    }
}
