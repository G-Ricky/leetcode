package com.leetcode.solution.problem386;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2022-04-18 23:04:09
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(List<Integer> expected, int n) {
        Assertions.assertEquals(expected, new Solution().lexicalOrder(n));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of(Arrays.asList(1,10,11,12,13,2,3,4,5,6,7,8,9), 13)
        );
    }
}