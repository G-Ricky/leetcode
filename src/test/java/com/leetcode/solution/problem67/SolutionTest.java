package com.leetcode.solution.problem67;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Ricky
 * @date 2020-06-23 02:17:03
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem67.SolutionTestFactory#test")
    public void test(String result, String a, String b) {
        Assertions.assertEquals(result, new Solution().addBinary(a, b));
    }
}
