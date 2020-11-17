package com.leetcode.solution.problem406;

import java.util.Arrays;

/**
 * 根据身高重建队列
 *
 * @author Ricky
 * @date 2020-11-16 23:35:09
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length <= 1) {
            return people;
        }
        Arrays.sort(people, (o1, o2) -> o1[0] - o2[0] == 0
            ? o2[1] - o1[1]
            : o1[0] - o2[0]
        );
        int i = people.length - 2;
        while (i >= 0) {
            move(people, i, i + people[i][1]);
            --i;
        }
        return people;
    }

    private void move(int[][] people, int srcIndex, int dstIndex) {
        int[] temp = people[srcIndex];
        int i = srcIndex;
        while (i < dstIndex) {
            people[i] = people[i + 1];
            ++i;
        }
        people[i] = temp;
    }
}
