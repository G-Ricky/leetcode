package com.leetcode.solution.problem44;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Ricky
 * @date 2020-07-05 22:14:27
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem44.SolutionTestFactory#test")
    void test(boolean result, String s, String p) {
        Assertions.assertEquals(result, new Solution().isMatch(s, p));
    }
}
