package com.leetcode.serializer;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ricky
 * @date 2020-06-22 02:00:37
 */
public class TreeSerializer implements Serializer<TreeNode> {

    @Override
    public String serialize(TreeNode serializable) {
        if (serializable == null) {
            return "[null]";
        }

        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(serializable);
        boolean isFirst = true;
        while (!queue.isEmpty()) {
            boolean isAllNull = true;
            for (TreeNode node : queue) {
                if (node != null) {
                    isAllNull = false;
                    break;
                }
            }
            if (isAllNull) {
                break;
            }

            // 按层遍历
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; ++i) {
                TreeNode node = queue.poll();
                if (isFirst) {
                    isFirst = false;
                } else {
                    sb.append(',');
                }
                if (node == null) {
                    sb.append("null");
                } else {
                    sb.append(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public TreeNode deserialize(String text) {
        if ("[null]".equals(text)) {
            return null;
        }

        String[] elements = text.substring(1, text.length() - 1).split(",");
        TreeNode[] nodes = new TreeNode[elements.length];
        for (int i = 0; i < elements.length; ++i) {
            if (!"null".equals(elements[i])) {
                nodes[i] = new TreeNode(Integer.parseInt(elements[i]));
            }
        }

        int j = 1;
        for (int i = 0; i < elements.length; ++i) {
            if (nodes[i] != null) {
                if (j < elements.length) {
                    nodes[i].left = nodes[j++];
                } else {
                    break;
                }
                if (j < elements.length) {
                    nodes[i].right = nodes[j++];
                } else {
                    break;
                }
            }
        }

        return nodes[0];
    }
}
