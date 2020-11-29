package com.leetcode.solution.problem767;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-11-30 01:11:46
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(String expected, String S) {
        Assertions.assertEquals(expected, new Solution().reorganizeString(S));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of("aba", "aab")
//            Arguments.of("dbdcdcdcdabab", "aabbbcccddddd")
        );
    }
}
