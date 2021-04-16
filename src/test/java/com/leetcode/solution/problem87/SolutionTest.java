package com.leetcode.solution.problem87;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2021-04-16 22:04:44
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(boolean expected, String s1, String s2) {
        Assertions.assertEquals(expected, new Solution().isScramble(s1, s2));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of(true, "great", "rgeat"),
            Arguments.of(false, "abcde", "caebd"),
            Arguments.of(true, "a", "a"),
            Arguments.of(true, "abcdbdacbdac", "bdacabcdbdac"),
            Arguments.of(true, "abc", "cba"),
            Arguments.of(true, "abcd", "bdca"),
            Arguments.of(false, "eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd")
        );
    }
}