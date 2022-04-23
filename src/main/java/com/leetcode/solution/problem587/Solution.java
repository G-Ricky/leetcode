package com.leetcode.solution.problem587;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 安装栅栏（未完成）
 *
 * @author Ricky
 * @date 2022-04-23 20:04:45
 */
public class Solution {

    public int[][] outerTrees(int[][] trees) {
        int num = trees.length;
        int[][] treesSortedByX = new int[num][2];
        int[][] treesSortedByY = new int[num][2];
        System.arraycopy(trees, 0, treesSortedByX, 0, num);
        System.arraycopy(trees, 0, treesSortedByY, 0, num);
        Arrays.sort(treesSortedByX, (o1, o2) ->
            o1[0] == o2[0]
                ? (Integer.compare(o1[1], o2[1]))
                : (o1[0] > o2[0] ? 1 : -1)
        );
        Arrays.sort(treesSortedByY, (o1, o2) ->
            o1[1] == o2[1]
                ? (Integer.compare(o1[0], o2[0]))
                : (o1[1] > o2[1] ? 1 : -1)
        );
        Set<Point> visited = new HashSet<>();
        Set<Point> currentVisited = new HashSet<>();
        int i = 0, j = num - 1, k = 0, l = num - 1;
        do {
            currentVisited.clear();
            if (i <= j) {
                Point point = Point.of(treesSortedByX[i][0], treesSortedByX[i][1]);
                if (!visited.contains(point)) {
                    currentVisited.add(point);
                    ++i;
                }
            }
            if (i <= j) {
                Point point = Point.of(treesSortedByX[j][0], treesSortedByX[j][1]);
                if (!visited.contains(point)) {
                    currentVisited.add(point);
                    --j;
                }
            }
            if (k <= l) {
                Point point = Point.of(treesSortedByY[k][0], treesSortedByY[k][1]);
                if (!visited.contains(point)) {
                    currentVisited.add(point);
                    ++k;
                }
            }
            if (k <= l) {
                Point point = Point.of(treesSortedByY[l][0], treesSortedByY[l][1]);
                if (!visited.contains(point)) {
                    currentVisited.add(point);
                    --l;
                }
            }
        } while (visited.addAll(currentVisited));

        int[][] result = new int[visited.size()][2];
        i = 0;
        for (Point point : visited) {
            result[i] = new int[] {point.x, point.y};
            i++;
        }
        return result;
    }

    public static class Point {

        private int x;

        private int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public static Point of(int x, int y) {
            Point point = new Point();
            point.x = x;
            point.y = y;
            return point;
        }
    }
}