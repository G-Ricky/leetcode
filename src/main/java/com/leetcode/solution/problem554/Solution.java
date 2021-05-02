package com.leetcode.solution.problem554;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 砖墙
 *
 * @author Ricky
 * @date 2021-05-02 20:05:47
 */
class Solution {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Long, Long> countMap = new HashMap<>();
        for (List<Integer> row : wall) {
            Long prev = null;
            long sum = 0;
            for (Integer num : row) {
                sum += num;
                countMap.put(sum, countMap.getOrDefault(sum, 0L) + 1L);
            }
        }
        long max = 0;
        long max1 = 0;
        for (Map.Entry<Long, Long> entry : countMap.entrySet()) {
            long count = entry.getValue();
            if (count >= max) {
                max1 = max;
                max = count;
            } else if (count >= max1) {
                max1 = count;
            }
        }
        return (int) (max - max1);
    }

}
