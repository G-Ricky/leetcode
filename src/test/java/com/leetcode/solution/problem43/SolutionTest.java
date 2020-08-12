package com.leetcode.solution.problem43;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-08-13 01:50:02
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(String result, String num1, String num2) {
        Assertions.assertEquals(result, new Solution().multiply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testStandard(String result, String num1, String num2) {
        Assertions.assertEquals(result, new StandardSolution().multiply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testOfficial(String result, String num1, String num2) {
        Assertions.assertEquals(result, new OfficialSolution().multiply(num1, num2));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of("6", "2", "3"),
            Arguments.of("0", "0", "456"),
            Arguments.of("0", "123", "0"),
            Arguments.of("0", "0", "0"),
            Arguments.of("0", "1", "0"),
            Arguments.of("456", "1", "456"),
            Arguments.of("123", "123", "1"),
            Arguments.of("1", "1", "1"),
            Arguments.of("56088", "123", "456"),
            Arguments.of("9998990001", "999999", "9999")
        );
    }
}
