package com.leetcode.solution.problem829;

/**
 * 连续整数求和（连续整数求和）
 *
 * @author Ricky
 * @date 2022-06-03 23:06:55
 */
public class Solution {

    public int consecutiveNumbersSum(int n) {
        if (n < 3) {
            return 1;
        }
        long nx = n * 10;
        int sum = 0;
        for (int i = 2; (i - 1) * 2 <= n; ++i) {
            // i ==> 组数
            long div = nx / i; // 中间的数 * 10
            if (nx % i != 0) { // 是否除得尽
                continue;
            }
            if ((i & 1) == 0 && div % 10 == 5) {// 分成偶数组
                long midRight = (div + 5) / 10;
                int halfGroup = (i >> 1);
                if (midRight - halfGroup >= 1) {
                    sum++;
                }
            } else if ((i & 1) == 1 && div % 10 == 0) { // 分成奇数组
                long mid = div / 10;
                int halfGroup = (i >> 1);
                if (mid - halfGroup >= 1) {
                    sum++;
                }
            }
        }
        return sum + 1;
    }
}