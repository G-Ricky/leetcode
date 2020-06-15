package com.leetcode.problem297;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 *
 * @author Ricky
 * @date 2020-06-16 00:51:23
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[null]";
        }

        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
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
                    queue.add(null);
                    queue.add(null);
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

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[null]".equals(data)) {
            return null;
        }

        String[] elements = data.substring(1, data.length() - 1).split(",");
        Map<Integer, TreeNode> treeNodeMap = new HashMap<>(64);
        for (int i = 0; i < elements.length; ++i) {
            if (!"null".equals(elements[i])) {
                treeNodeMap.put(i, new TreeNode(Integer.parseInt(elements[i])));
            }
        }

        for (Map.Entry<Integer, TreeNode> entry : treeNodeMap.entrySet()) {
            Integer index = entry.getKey();
            TreeNode node = entry.getValue();
            node.left = treeNodeMap.get(index * 2 + 1);
            node.right = treeNodeMap.get(index * 2 + 2);
        }

        return treeNodeMap.get(0);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(codec.deserialize(codec.serialize(node1)));
    }
}
