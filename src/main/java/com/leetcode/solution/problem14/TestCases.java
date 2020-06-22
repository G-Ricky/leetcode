package com.leetcode.solution.problem14;

/**
 * @author Ricky
 * @date 2020-06-15 01:28:21
 */
public class TestCases {

    public static void test() {
        String[] strs1 = {"flower","flow","flight"};
        String ans1 = "fl";

        String[] strs2 = {"dog","racecar","car"};
        String ans2 = "";

        Solution solution = new Solution();
        assert ans1.equals(solution.longestCommonPrefix(strs1));
        assert ans2.equals(solution.longestCommonPrefix(strs2));
    }
}
