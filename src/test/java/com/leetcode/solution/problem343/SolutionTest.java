package com.leetcode.solution.problem343;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Ricky
 * @date 2020-07-30 00:46:12
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem343.SolutionTestFactory#test")
    void test(int result, int n) {
        Assertions.assertEquals(result, new Solution().integerBreak(n));
    }
}
