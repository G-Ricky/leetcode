package com.leetcode.solution.problem834;

import java.util.*;

/**
 * 树中距离之和
 *
 * @author Ricky
 * @date 2020-10-07 00:19:51
 */
public class Solution {

    private Map<Integer, Map<Integer, Integer>> map;

    private int[][] edges;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        // 两级 HashMap
        this.map = new HashMap<>(N);
        this.edges = edges;
        for (int i = 0; i < edges.length; ++i) {
            Map<Integer, Integer> second = map.computeIfAbsent(edges[i][0], k -> new HashMap<>(N));
            second.put(edges[i][1], 1);
            second = map.computeIfAbsent(edges[i][1], k -> new HashMap<>(N));
            second.put(edges[i][0], 1);
        }

        int[] nodes = new int[N];
        int i = 0;
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : map.entrySet()) {
            nodes[i++] = entry.getKey();
        }

        for (i = 0; i < nodes.length; ++i) {
            dfs(nodes[i], nodes[i], 0, new HashSet<>());
        }

        int[] result = new int[N];
        for (i = 0; i < nodes.length; ++i) {
            for (int j = 0; j < nodes.length; ++j) {
                if (nodes[i] != nodes[j]) {
                    result[i] += map.getOrDefault(nodes[i], Collections.emptyMap())
                        .getOrDefault(nodes[j], 0);
                }
            }
        }
        return result;
    }

    private void dfs(int root, int node, int depth, Set<Integer> visited) {
        visited.add(node);
        if (root != node) {
            Map<Integer, Integer> second = map.computeIfAbsent(root, k -> Collections.emptyMap());
            int minDepth = second.getOrDefault(node, Integer.MAX_VALUE);
            second.put(node, Math.min(depth, minDepth));
        }
        Map<Integer, Integer> second = map.get(node);
        if (second == null || second.isEmpty()) {
            return;
        }
        int[] children = new int[second.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : second.entrySet()) {
            children[i++] = entry.getKey();
        }
        for (int child : children) {
            if (visited.contains(child)) {
                continue;
            }
            dfs(root, child, depth + 1, visited);
        }
    }
}
