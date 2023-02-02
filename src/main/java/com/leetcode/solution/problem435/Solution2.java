package com.leetcode.solution.problem435;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author Ricky
 * @date 2023-01-31 22:01:25
 */
public class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                return o1[1] > o2[1]
                    ? 1
                    : (o1[1] < o2[1] ? -1 : 0);
            }
        });
        int n = intervals.length;
        int[] dp = new int[n];
        // 按右边界排序的索引集合
        // key: 右边界
        // value: 右边界等于 key 的区间索引集合
        Map<Integer, List<Integer>> rightBoundMap = new TreeMap<>();
        for (int i = 0; i < n; ++i) {
            int[] interval = intervals[i];
            int rightBound = interval[1];
            rightBoundMap.computeIfAbsent(rightBound, k -> new ArrayList<>())
                .add(i);
        }
        Arrays.fill(dp, 1);
        int keepCount = 1;
        for (int i = 0; i < n; ++i) {
            int[] interval = intervals[i];
            Iterator<Entry<Integer, List<Integer>>> iterator = rightBoundMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<Integer, List<Integer>> entry = iterator.next();
                int closedRightBound = entry.getKey(); // 其右边界最接近当前区间左边界的区间
                int leftBound = interval[0];
                if (closedRightBound <= leftBound) {
                    List<Integer> indexList = entry.getValue();
                    for (Integer index : indexList) {
                        keepCount = Math.max(keepCount, dp[index] + 1);
                    }
                    dp[i] = keepCount;
                    iterator.remove();
                } else {
                    dp[i] = keepCount;
                    break;
                }
            }
        }
        return n - keepCount;
    }
}
