package com.leetcode.solution.problem447;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 回旋镖的数量
 *
 * @author Ricky
 * @date 2021-09-14 00:09:08
 */
public class Solution {

    public int numberOfBoomerangs(int[][] points) {
        // Map<Distance, Map<StartPoint, EndPoints>>
        Map<Integer, Map<int[], Set<int[]>>> distancePointMap = new HashMap<>();
        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                int distanceSquare = x * x + y * y;
                Map<int[], Set<int[]>> startEndPointMap = distancePointMap.computeIfAbsent(distanceSquare, k -> new HashMap<>());
                startEndPointMap.computeIfAbsent(points[i], k -> new HashSet<>())
                    .add(points[j]);
                startEndPointMap.computeIfAbsent(points[j], k -> new HashSet<>())
                    .add(points[i]);
            }
        }
        int sum = 0;
        for (Map.Entry<Integer, Map<int[], Set<int[]>>> entry : distancePointMap.entrySet()) {
            Map<int[], Set<int[]>> startEndPointMap = entry.getValue();
            for (Map.Entry<int[], Set<int[]>> startEndPointEntry : startEndPointMap.entrySet()) {
                int s = startEndPointEntry.getValue().size();
                sum += s * (s - 1);
            }
        }
        return sum;
    }
}
