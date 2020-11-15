package com.leetcode.solution.problem402;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-11-15 16:30:49
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(String expected, String num, int k) {
        Assertions.assertEquals(expected, new Solution().removeKdigits(num, k));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of("1270219", "1432780219", 3),
            Arguments.of("1219", "1432219", 3),
            Arguments.of("200", "10200", 1),
            Arguments.of("0", "10", 2),
            Arguments.of("0", "10", 1),
            Arguments.of("11", "112", 1),
            Arguments.of("11", "20112", 2),
            Arguments.of("1111", "1111111", 3),
            Arguments.of("0", "1234567890", 9),
            Arguments.of("0", "100", 1)
        );
    }
}
