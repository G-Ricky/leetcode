package com.leetcode.solution.problem215;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Ricky
 * @date 2020-06-29 22:35:19
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem215.SolutionTestFactory#test")
    void test(int result, int[] nums, int k) {
        Assertions.assertEquals(result, new Solution().findKthLargest(nums, k));
    }
}
