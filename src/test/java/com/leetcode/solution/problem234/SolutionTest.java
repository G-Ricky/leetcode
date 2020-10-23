package com.leetcode.solution.problem234;

import com.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-10-23 22:37:42
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(boolean expected, ListNode head) {
        Assertions.assertEquals(expected, new Solution().isPalindrome(head));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of(true, "[]"),
            Arguments.of(true, "[1]"),
            Arguments.of(false, "[1,2]"),
            Arguments.of(true, "[1,1]"),
            Arguments.of(false, "[1,2,3]"),
            Arguments.of(true, "[1,2,1]"),
            Arguments.of(false, "[1,2,3,4]"),
            Arguments.of(false, "[1,2,2,4]"),
            Arguments.of(false, "[1,2,3,1]"),
            Arguments.of(true, "[1,2,2,1]"),
            Arguments.of(true, "[1,2,2,2,1]"),
            Arguments.of(false, "[1,3,2,2,1]"),
            Arguments.of(true, "[1,2,3,2,1]"),
            Arguments.of(true, "[2,3,2,3,2]"),
            Arguments.of(true, "[2,3,2,2,3,2]")
        );
    }
}
