package com.leetcode.solution.problem449;

import com.leetcode.TreeNode;

/**
 * 序列化和反序列化二叉搜索树
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        String text = sb.toString();
        System.out.println(text);
        return text;
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null");
            return;
        }
        if (node.left == null && node.right == null) {
            sb.append(node.val);
            return;
        }
        sb.append("[");
        serialize(node.left, sb);
        sb.append(",")
            .append(node.val)
            .append(",");
        serialize(node.right, sb);
        sb.append("]");
    }

    private int pos;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("null".equals(data)) {
            return null;
        } else if (Character.isDigit(data.charAt(0))) {
            return new TreeNode(Integer.parseInt(data));
        }
        pos = 0;
        TreeNode root = parseNode(data);
        pos = 0;
        return root;
    }

    private TreeNode parseNode(String text) {
        TreeNode left;
        pos += "[".length();
        if (isExpected(text, "[")) {
            left = parseNode(text);
        } else if (isExpected(text, "null")) {
            left = parseNull(text);
        } else {
            left = parseDigit(text);
        }

        pos += ",".length();

        TreeNode node = parseDigit(text);

        pos += ",".length();

        TreeNode right;
        if (isExpected(text, "[")) {
            right = parseNode(text);
        } else if (isExpected(text, "null")) {
            right = parseNull(text);
        } else {
            right = parseDigit(text);
        }

        pos += "]".length();
        node.left = left;
        node.right = right;
        return node;
    }

    private boolean isExpected(String text, String expected) {
        if (pos + expected.length() > text.length()) {
            return false;
        }
        for (int i = 0; i < expected.length(); ++i) {
            if (text.charAt(pos + i) != expected.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private TreeNode parseDigit(String text) {
        int i = 0;
        while (pos + i < text.length()) {
            char ch = text.charAt(pos + i);
            if (!Character.isDigit(ch)) {
                break;
            }
            ++i;
        }
        int val = Integer.parseInt(text.substring(pos, pos + i));
        pos += i;
        return new TreeNode(val);
    }

    private TreeNode parseNull(String text) {
        pos += "null".length();
        return null;
    }
}