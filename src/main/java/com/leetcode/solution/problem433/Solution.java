package com.leetcode.solution.problem433;

import java.util.*;

/**
 * 最小基因变化
 *
 * @author Ricky
 * @date 2022-05-07 23:05:40
 */
public class Solution {

    private int min = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < bank.length; ++i) {
            if (computeDifference(start, bank[i]) <= 1) {
                graph.computeIfAbsent(start, k -> new ArrayList<>())
                    .add(bank[i]);
                graph.computeIfAbsent(bank[i], k -> new ArrayList<>())
                    .add(start);
            }
            for (int j = i + 1; j < bank.length; ++j) {
                if (computeDifference(bank[i], bank[j]) <= 1) {
                    graph.computeIfAbsent(bank[i], k -> new ArrayList<>())
                        .add(bank[j]);
                    graph.computeIfAbsent(bank[j], k -> new ArrayList<>())
                        .add(bank[i]);
                }
            }
        }
        Set<String> visited = new HashSet<>();
        visited.add(start);
        findEnd(start, end, graph, visited);
        if (min == Integer.MAX_VALUE) {
            return -1;
        } else {
            return min;
        }
    }

    private void findEnd(String current, String end, Map<String, List<String>> graph, Set<String> visited) {
        List<String> nodes = graph.get(current);
        if (nodes != null && !nodes.isEmpty()) {
            for (String node : nodes) {
                if (visited.contains(node)) {
                    continue;
                }
                visited.add(node);
                if (node.equals(end)) {
                    min = Math.min(visited.size() - 1, min);
                    visited.remove(node);
                    return;
                }
                findEnd(node, end, graph, visited);
                visited.remove(node);
            }
        }
    }

    private int computeDifference(String left, String right) {
        int diff = 0;
        for (int i = 0; i < left.length(); ++i) {
            if (left.charAt(i) != right.charAt(i)) {
                ++diff;
                if (diff > 1) {
                    break;
                }
            }
        }
        return diff;
    }
}
