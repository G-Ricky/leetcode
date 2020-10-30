package com.leetcode.solution.problem1365;

import com.leetcode.converter.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-10-26 01:24:20
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(
        @ConvertWith(IntArrayConverter.class) int[] expected,
        @ConvertWith(IntArrayConverter.class) int[] nums) {
        Assertions.assertArrayEquals(expected, new Solution().smallerNumbersThanCurrent(nums));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of("[4,0,1,1,3]", "[8,1,2,2,3]")
        );
    }
}
