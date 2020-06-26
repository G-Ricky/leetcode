package com.leetcode.solution.problem120;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

/**
 * @author Ricky
 * @date 2020-06-26 23:08:36
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem120.SolutionTestFactory#test")
    void test(int result, List<List<Integer>> triangle) {
        Assertions.assertEquals(result, new Solution().minimumTotal(triangle));
    }
}
