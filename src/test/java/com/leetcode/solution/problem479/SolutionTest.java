package com.leetcode.solution.problem479;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2022-04-16 21:04:51
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(int expected, int n) {
        Assertions.assertEquals(expected, new Solution().largestPalindrome(n));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of(9, 1),
            Arguments.of(987, 2),
            Arguments.of(123, 3),
            Arguments.of(597, 4),
            Arguments.of(677, 5),
            Arguments.of(1218, 6),
            Arguments.of(877, 7),
            Arguments.of(475, 8)
        );
    }
}