package com.leetcode.solution.problem514;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-11-11 23:45:19
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(int expected, String ring, String key) {
        Assertions.assertEquals(expected, new Solution().findRotateSteps(ring, key));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of(4, "godding", "gd")
        );
    }
}
