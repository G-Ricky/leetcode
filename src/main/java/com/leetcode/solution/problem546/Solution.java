package com.leetcode.solution.problem546;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 移除盒子
 *
 * @author Ricky
 * @date 2020-08-15 19:34:52
 */
public class Solution {
    public int removeBoxes(int[] boxes) {
        if (boxes.length <= 1) {
            return boxes.length;
        }

        Map<Range, Integer> dp = new HashMap<>(boxes.length);
        Map<Integer, Integer> prevIndexMap = new HashMap<>(boxes.length);
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < boxes.length; ++i) {
            if (i == 0) {
                dp.put(new Range(0, 0), 1);
            } else {
                int score = dp.getOrDefault(new Range(0, i - 1), 0) + 1;
                Integer prevIndex = prevIndexMap.get(boxes[i]);
                if (prevIndex != null) {
                    int count = 2;
                    int j = prevIndex - 1;
                    while (j >= 0 && boxes[j] == boxes[i]) {
                        ++count;
                        --j;
                    }
                    int otherScore = count * count
                        + dp.getOrDefault(new Range(0, j), 0)
                        + (i - prevIndex - 1) * (i - prevIndex - 1);
                    score = Math.max(score, otherScore);
                }
                dp.put(new Range(0, i), score);
                maxScore = Math.max(score, maxScore);
            }
            prevIndexMap.put(boxes[i], i);
        }

        return -1;
        // return maxScore;
    }

    static class Range {

        public int i;

        public int j;

        public Range(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Range that = (Range) o;
            return this.i == that.i && this.j == that.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
