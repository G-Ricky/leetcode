package com.leetcode.problem231;

/**
 * 2的幂
 *
 * @author Ricky
 * @date 2020-06-21 23:15:16
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int i = 0;
        for (; i < 32; ++i) {
            if (((n >> i) & 1) == 1) {
                break;
            }
        }

        return (n >> i) == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        assert solution.isPowerOfTwo(1) == true;
        assert solution.isPowerOfTwo(16) == true;
        assert solution.isPowerOfTwo(218) == false;
        assert solution.isPowerOfTwo(6) == false;
        assert solution.isPowerOfTwo(3) == false;
    }
}
