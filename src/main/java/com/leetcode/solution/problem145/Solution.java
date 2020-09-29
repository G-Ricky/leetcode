package com.leetcode.solution.problem145;

import com.leetcode.TreeNode;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的后序遍历
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author Ricky
 * @date 2020-09-29 23:01:41
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        if (root.left == null && root.right == null) {
            return Collections.singletonList(root.val);
        }
        Deque<Frame> stack = new LinkedList<>();
        stack.push(new Frame(0, root));
        List<Integer> result = new LinkedList<>();
        while (!stack.isEmpty()) {
            Frame frame = stack.pop();
            switch (frame.position) {
                case 0:
                    if (frame.node == null) {
                        continue;
                    }
                    frame.position++;
                case 1:
                    call(stack, frame, frame.node.left);
                    break;
                case 2:
                    call(stack, frame, frame.node.right);
                    break;
                case 3:
                    result.add(frame.node.val);
                    frame.position++;
                default:
            }
        }
        return result;
    }

    private void call(Deque<Frame> stack, Frame frame, Object ...args) {
        // stack current frame
        frame.position++;
        stack.push(frame);
        // create new frame
        stack.push(new Frame(0, (TreeNode) args[0]));
    }

    public static class Frame {

        public int position = 0;

        public TreeNode node;

        public Frame(int position, TreeNode node) {
            this.position = position;
            this.node = node;
        }
    }
}
