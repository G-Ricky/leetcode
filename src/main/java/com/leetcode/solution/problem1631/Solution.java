package com.leetcode.solution.problem1631;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 最小体力消耗路径
 * @author Ricky
 */
public class Solution {
    public int minimumEffortPath(int[][] heights) {
        if (heights.length == 1 && heights[0].length == 1) {
            return 0;
        }
        if (heights.length == 1) {
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < heights[0].length; ++i) {
                max = Math.max(max, Math.abs(heights[0][i - 1] - heights[0][i]));
            }
            return max;
        }
        if (heights[0].length == 1) {
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < heights.length; ++i) {
                max = Math.max(max, Math.abs(heights[i - 1][0] - heights[i][0]));
            }
            return max;
        }
        int row = heights.length;
        int col = heights[0].length;
        int total = row * col;
        List<Edge> edges = new ArrayList<>(total);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (j + 1 < col) {
                    Edge edge = new Edge();
                    edge.point1 = new int[] {i, j};
                    edge.point2 = new int[] {i, j + 1};
                    edge.cost = Math.abs(heights[i][j] - heights[i][j + 1]);
                    edges.add(edge);
                }
                if (i + 1 < row) {
                    Edge edge = new Edge();
                    edge.point1 = new int[] {i, j};
                    edge.point2 = new int[] {i + 1, j};
                    edge.cost = Math.abs(heights[i][j] - heights[i + 1][j]);
                    edges.add(edge);
                }
            }
        }
        edges.sort(Comparator.comparing(Edge::getCost));

        int[] arr = new int[total];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = i;
        }
        int index = 0;
        int maxCost = Integer.MIN_VALUE;
        while (index < edges.size() && find(arr, arr[0]) != find(arr, arr[total - 1])) {
            Edge edge = edges.get(index);
            int p1 = edge.point1[0] * col + edge.point1[1];
            int p2 = edge.point2[0] * col + edge.point2[1];
            maxCost = Math.max(maxCost, edge.cost);
            merge(arr, p1, p2);
            index++;
        }
        return maxCost;
    }

    int find(int arr[], int x) {
        if (x == arr[x]) {
            return x;
        } else {
            return arr[x] = find(arr, arr[x]);
        }
    }

    void merge(int arr[], int x, int y) {
        arr[find(arr, x)] = find(arr, y);
    }

    static class Edge {

        int[] point1;

        int[] point2;

        int cost;

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }
}