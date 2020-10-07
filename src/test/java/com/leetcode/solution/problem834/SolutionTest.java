package com.leetcode.solution.problem834;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-10-07 00:21:51
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(int[] expected, int N, int[][] edges) {
        Assertions.assertArrayEquals(expected, new Solution().sumOfDistancesInTree(N, edges));
    }

    static Stream<Arguments> testSource() {
        int[] expected = new int[]{8, 12, 6, 10, 10, 10};
        int N = 6;
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        return Stream.of(
            Arguments.of(expected, N, edges)
        );
    }
}
