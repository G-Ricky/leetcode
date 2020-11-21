package com.leetcode.solution.problem148;

import com.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-11-21 01:58:55
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(ListNode expected, ListNode head) {
        Assertions.assertEquals(expected, new Solution().sortList(head));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of("[1,2,3,4]", "[4,2,1,3]"),
            Arguments.of("[1]", "[1]"),
            Arguments.of("[1,2]", "[1,2]"),
            Arguments.of("[1,2]", "[2,1]"),
            Arguments.of("[1,1]", "[1,1]"),
            Arguments.of("[1,1,2,2,3,3]", "[1,2,3,3,2,1]")
        );
    }
}
