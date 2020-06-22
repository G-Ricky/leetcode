package com.leetcode.solution.problem338;

import java.util.Arrays;

/**
 * 比特位计数
 *
 * @author Ricky
 * @date 2020-06-22 00:37:11
 */
public class Solution {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[] {0};
        }
        if (num == 1) {
            return new int[] {0, 1};
        }
        int high = 1;
        int[] ans = new int[num + 1];
        // ans[0] = 0;
        for (int i = 1; i <= num; ++i) {
            if ((i & high) == 0) {
                high = high << 1;
            }
            ans[i] = ans[i - high] + 1;
        }

        return ans;
    }
}
