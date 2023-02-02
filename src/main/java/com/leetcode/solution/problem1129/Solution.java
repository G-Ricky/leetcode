package com.leetcode.solution.problem1129;

import java.util.*;

/**
 * 颜色交替的最短路径
 *
 * @author Ricky
 * @date 2023-02-02 21:02:36
 */
public class Solution {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] redRes = new int[n];
        int[] blueRes = new int[n];
        Arrays.fill(redRes, -1);
        Arrays.fill(blueRes, -1);
        redRes[0] = 0;
        blueRes[0] = 0;
        Map<Integer, Set<Integer>> redEdgeMap = new HashMap<>();
        Map<Integer, Set<Integer>> blueEdgeMap = new HashMap<>();
        for (int i = 0; i < redEdges.length; ++i) {
            redEdgeMap.computeIfAbsent(redEdges[i][0], k -> new HashSet<>())
                .add(redEdges[i][1]);
        }
        for (int i = 0; i < blueEdges.length; ++i) {
            blueEdgeMap.computeIfAbsent(blueEdges[i][0], k -> new HashSet<>())
                .add(blueEdges[i][1]);
        }
        Set<Integer> nextLevel = new HashSet<>();
        // [7...0] 点编号
        // [8] 红色
        // [9] 蓝色
        nextLevel.add(colorPoint(0, true, true));
        Set<Integer> visitedColoredPoints = new HashSet<>();
        int level = 0;
        while (!nextLevel.isEmpty()) {
            Set<Integer> currentLevel = nextLevel;
            nextLevel = new HashSet<>();
            Set<Integer> newVisited = new HashSet<>();
            for (Integer coloredPoint : currentLevel) {
                // 上一条边为红色
                int point = getPointNumber(coloredPoint);
                computeGeneration(isRed(coloredPoint), point, true, redRes, blueRes, redEdgeMap, blueEdgeMap, visitedColoredPoints, newVisited, nextLevel, level);
                computeGeneration(isBlue(coloredPoint), point, false, blueRes, redRes, blueEdgeMap, redEdgeMap, visitedColoredPoints, newVisited, nextLevel, level);
            }
            visitedColoredPoints.addAll(newVisited);
            level++;
        }
        for (int i = 0; i < redRes.length; ++i) {
            if (redRes[i] != -1 && blueRes[i] != -1) {
                redRes[i] = Math.min(redRes[i], blueRes[i]);
            } else if (redRes[i] == -1) {
                redRes[i] = blueRes[i];
            }
        }
        return redRes;
    }


    private int getPointNumber(int value) {
        return value & 0xFF;
    }

    private boolean isRed(int value) {
        return (value & (1 << 8)) != 0;
    }

    private boolean isBlue(int value) {
        return (value & (1 << 9)) != 0;
    }

    private int colorPoint(int pointNumber, boolean isRed, boolean isBlue) {
        return pointNumber | (isRed ? 1 << 8 : 0) | (isBlue ? 1 << 9 : 0);
    }

    private void computeGeneration(boolean isOneColor, int point, boolean isRed, int[] oneRes, int[] otherRes, Map<Integer, Set<Integer>> oneEdgeMap, Map<Integer, Set<Integer>> otherEdgeMap, Set<Integer> visitedColoredPoints, Set<Integer> newVisited, Set<Integer> nextLevel, int level) {
        if (!isOneColor) {
            return;
        }
        int coloredPoint = colorPoint(point, isRed, !isRed);
        if (visitedColoredPoints.contains(coloredPoint)) { {
            return;
        }}
        newVisited.add(coloredPoint);
        oneRes[point] = level;
        Set<Integer> otherNextLevel = otherEdgeMap.get(point);
        if (otherNextLevel == null) {
            return;
        }
        for (Integer next : otherNextLevel) {
            // 将下一个点与入边染成与当前颜色相反的颜色
            int nextColoredPoint = colorPoint(next, !isRed, isRed);
            nextLevel.add(nextColoredPoint);
        }
    }
}
