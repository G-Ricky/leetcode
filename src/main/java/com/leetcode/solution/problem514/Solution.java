package com.leetcode.solution.problem514;

import java.util.*;

/**
 * 自由之路
 *
 * @author Ricky
 * @date 2020-11-11 23:44:15
 */
public class Solution {

    public int findRotateSteps(String ring, String key) {
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < ring.length(); ++i) {
            indexMap.computeIfAbsent(ring.charAt(i), k -> new ArrayList<>(10))
                .add(i);
        }
        int ringSize = ring.length();
        int keySize = key.length();
        int[][] temp = new int[ringSize][2];
        List<Integer> prevIndexList;
        List<Integer> currentIndexList;
        for (int i = 0; i < keySize; ++i) {
            prevIndexList = i == 0
                ? Collections.singletonList(0)
                : indexMap.get(key.charAt(i - 1));
            currentIndexList = indexMap.get(key.charAt(i));
            for (Integer currentIndex : currentIndexList) {
                int min = Integer.MAX_VALUE;
                for (Integer prevIndex : prevIndexList) {
                    int innerDistance = Math.abs(currentIndex - prevIndex) + 1;
                    int outerDistance = ringSize - Math.abs(prevIndex - currentIndex) + 1;
                    int distance = Math.min(innerDistance, outerDistance);
                    min = Math.min(min, distance + temp[prevIndex][0]);
                }
                temp[currentIndex][1] = min;
            }
            // 滚动
            for (Integer currentIndex : currentIndexList) {
                temp[currentIndex][0] = temp[currentIndex][1];
            }
        }

        char lastChar = key.charAt(keySize - 1);
        int min = Integer.MAX_VALUE;
        for (Integer index : indexMap.get(lastChar)) {
            min = Math.min(min, temp[index][1]);
        }
        return min;
    }
}
