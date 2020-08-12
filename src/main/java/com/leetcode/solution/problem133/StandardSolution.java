package com.leetcode.solution.problem133;

import java.util.*;

/**
 * @author Ricky
 * @date 2020-08-12 14:26:15
 */
public class StandardSolution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new IdentityHashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node, new Node(node.val, new ArrayList<>(node.neighbors.size())));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>(neighbor.neighbors.size())));
                    queue.offer(neighbor);
                }
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}
