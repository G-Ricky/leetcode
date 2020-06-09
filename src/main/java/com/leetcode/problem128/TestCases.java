package com.leetcode.problem128;

/**
 * @author Ricky
 * @date 2020-06-06 16:51:55
 */
public class TestCases {

    public static void test() {
        int[] nums = {100, 4, 200, 1, 3, 2};

        Solution solution = new Solution();
        assert solution.longestConsecutive(nums) == 4;
        assert solution.longestConsecutive(new int[] {}) == 0;
        assert solution.longestConsecutive(new int[] {2}) == 1;
        assert solution.longestConsecutive(new int[] {2, 3}) == 2;
        assert solution.longestConsecutive(new int[] {3, 2}) == 2;
        assert solution.longestConsecutive(new int[] {0, -1}) == 2;
        assert solution.longestConsecutive(new int[] {0, 0, -1}) == 2;
    }
}
