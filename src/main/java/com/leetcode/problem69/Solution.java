package com.leetcode.problem69;

/**
 * x 的平方根
 *
 * @author Ricky
 * @date 2020-06-17 23:38:16
 */
public class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int mid = 0;
        boolean isGreater = false;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid > 0 && mid > x / mid) {
                right = mid - 1;
                isGreater = true;
            } else if (mid == 0 || mid < x / mid) {
                left = mid + 1;
                isGreater = false;
            } else {
                return mid;
            }
        }

        return isGreater
            ? mid - 1
            : mid;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i > -1; ++i) {
            assert solution.mySqrt(i) == (int) Math.sqrt(i);
        }
    }
}
