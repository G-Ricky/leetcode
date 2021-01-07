package com.leetcode.solution.problem547;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 省份数量
 *
 * @author Ricky
 * @date 2021-01-07 22:01:48
 */
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> province = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < isConnected.length; ++i) {
            if (visited.contains(i)) {
                continue;
            }
            province.offer(i);
            while (!province.isEmpty()) {
                int i0 = province.poll();
                if (visited.contains(i0)) {
                    continue;
                }
                for (int j = 0; j < isConnected[i0].length; ++j) {
                    if (visited.contains(j)) {
                        continue;
                    }
                    if (isConnected[i0][j] == 1) {
                        province.offer(j);
                    }
                }
                visited.add(i0);
            }
            ++res;
        }
        return res;
    }
}
