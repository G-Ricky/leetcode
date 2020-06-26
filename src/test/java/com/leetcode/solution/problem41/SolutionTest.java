package com.leetcode.solution.problem41;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Ricky
 * @date 2020-06-27 01:09:36
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem41.SolutionTestFactory#test")
    void test(int result, int[] nums) {
        Assertions.assertEquals(result, new Solution().firstMissingPositive(nums));
    }
}
