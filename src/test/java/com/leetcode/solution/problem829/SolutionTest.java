package com.leetcode.solution.problem829;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2022-06-03 23:06:38
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(int expected, int n) {
        Assertions.assertEquals(expected, new Solution().consecutiveNumbersSum(n));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of(8, 10002234),
            Arguments.of(4, 85),
            Arguments.of(2, 5),
            Arguments.of(3, 9),
            Arguments.of(4, 15),
            Arguments.of(4, 77601076),
            Arguments.of(2, 3),
            Arguments.of(12, 246854111)
        );
    }
}