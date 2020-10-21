package com.leetcode.solution.problem925;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-10-21 22:53:41
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(boolean expected, String name, String typed) {
        Assertions.assertEquals(expected, new Solution().isLongPressedName(name, typed));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of(true, "alex", "aaleex"),
            Arguments.of(false, "saeed", "ssaaedd"),
            Arguments.of(true, "leelee", "lleeelee"),
            Arguments.of(true, "laiden", "laiden"),
            Arguments.of(true, "a", "a"),
            Arguments.of(false, "a", ""),
            Arguments.of(false, "", "a"),
            Arguments.of(true, "", ""),
            Arguments.of(false, "aa", "a"),
            Arguments.of(true, "a", "aa"),
            Arguments.of(false, "aa", "aac"),
            Arguments.of(false, "aaaaaa", "aac"),
            Arguments.of(false, "aa", "aaaaaac"),
            Arguments.of(false, "a", "c"),
            Arguments.of(true, "ac", "aac")
        );
    }
}
