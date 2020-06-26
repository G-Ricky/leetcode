package com.leetcode.solution.problem139;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

/**
 * @author Ricky
 * @date 2020-06-26 17:21:37
 */
public class SolutionTest {
    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem139.SolutionTestFactory#test")
    void test(Boolean result, String s, List<String> wordDict) {
        Assertions.assertEquals(result, new Solution().wordBreak(s, wordDict));
    }
}
