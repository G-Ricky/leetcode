package com.leetcode.solution.problem427;

/**
 * 建立四叉树
 *
 * @author Ricky
 * @date 2022-04-29 22:04:24
 */
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {

    public Node construct(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        NodeWrapper nodeWrapper = construct(grid, 0, m - 1, 0, n - 1);
        return nodeWrapper.node;
    }

    public NodeWrapper construct(int[][] grid, int top, int bottom, int left, int right) {
        if (top == bottom && left == right) {
            return new NodeWrapper(new Node(grid[top][left] == 1, true), grid[top][left]);
        } else {
            int topBottom = (top + bottom) / 2;
            int leftRight = (left + right) / 2;
            int bottomTop = (top + bottom) / 2 + 1;
            int rightLeft = (left + right) / 2 + 1;
            NodeWrapper topLeft = construct(grid, top, topBottom, left, leftRight);
            NodeWrapper topRight = construct(grid, top, topBottom, rightLeft, right);
            NodeWrapper bottomLeft = construct(grid, bottomTop, bottom, left, leftRight);
            NodeWrapper bottomRight = construct(grid, bottomTop, bottom, rightLeft, right);
            if (topLeft.nestedValue == topRight.nestedValue && topRight.nestedValue == bottomLeft.nestedValue && bottomLeft.nestedValue == bottomRight.nestedValue && bottomRight.nestedValue != -1) {
                return new NodeWrapper(new Node(topLeft.node.val, true, null, null, null, null), topLeft.nestedValue);
            } else {
                return new NodeWrapper(new Node(false, false, topLeft.node, topRight.node, bottomLeft.node, bottomRight.node), -1);
            }
        }
    }

    public static class NodeWrapper {

        private Node node;

        private int nestedValue;

        public NodeWrapper(Node node, int nestedValue) {
            this.node = node;
            this.nestedValue = nestedValue;
        }
    }
}