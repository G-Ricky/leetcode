package com.leetcode.solution.problem133;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.*;

/**
 * 克隆图
 *
 * @author Ricky
 * @date 2020-08-12 00:53:48
 */
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node currentCopy = new Node(current.val, new ArrayList<>(current.neighbors.size()));
            visited.put(current.val, currentCopy);
            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor.val)) {
                    queue.offer(neighbor);
                }
            }
        }

        queue.offer(node);
        Set<Integer> visited2 = new HashSet<>();
        visited2.add(node.val);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node currentCopy = visited.get(current.val);
            for (Node neighbor : current.neighbors) {
                currentCopy.neighbors.add(visited.get(neighbor.val));
                if (!visited2.contains(neighbor.val)) {
                    queue.offer(neighbor);
                    visited2.add(neighbor.val);
                }
            }
        }

        return visited.get(node.val);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}