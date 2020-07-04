package com.leetcode.solution.problem32;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Ricky
 * @date 2020-07-04 21:19:34
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem32.SolutionTestFactory#test")
    void test(int result, String s) {
        Assertions.assertEquals(result, new Solution().longestValidParentheses(s));
    }
}
