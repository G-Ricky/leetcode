package com.leetcode.solution.problem17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-08-26 20:20:10
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(List<String> expected, String digits) {
        List<String> result = new Solution().letterCombinations(digits);
        result.sort(String::compareTo);
        expected.sort(String::compareTo);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> testSource() {
        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        return Stream.of(
            Arguments.of(expected, "23")
        );
    }
}
