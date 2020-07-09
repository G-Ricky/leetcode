package com.leetcode.solution.interview1713;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Ricky
 * @date 2020-07-09 22:52:14
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.interview1713.SolutionTestFactory#test")
    void test(int result, String[] dictionary, String sentence) {
        Assertions.assertEquals(result, new Solution().respace(dictionary, sentence));
    }
}
