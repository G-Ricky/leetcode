package com.leetcode.solution.problem139;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

/**
 * @author Ricky
 * @date 2020-06-25 17:41:50
 */
public class TrieSolutionTest {
    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem139.TrieSolutionTestFactory#test")
    void test(Boolean result, String s, List<String> wordDict) {
        Assertions.assertEquals(result, new TrieSolution().wordBreak(s, wordDict));
    }
}
