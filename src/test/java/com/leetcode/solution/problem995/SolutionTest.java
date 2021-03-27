package com.leetcode.solution.problem995;

import com.leetcode.converter.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2021-02-18 21:02:10
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(
        int expected,
        @ConvertWith(IntArrayConverter.class) int[] A,
        int K
    ) {
        Assertions.assertEquals(expected, new Solution().minKBitFlips(A, K));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of(2, "[0,1,0]", 1),
            Arguments.of(-1, "[1,1,0]", 2),
            Arguments.of(3, "[0,0,0,1,0,1,1,0]", 3)
        );
    }
}