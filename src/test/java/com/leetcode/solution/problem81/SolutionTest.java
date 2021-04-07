package com.leetcode.solution.problem81;

import com.leetcode.converter.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2021-04-07 23:04:58
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(
        boolean expected,
        @ConvertWith(IntArrayConverter.class) int[] nums,
        int target
    ) {
        Assertions.assertEquals(expected, new Solution().search(nums, target));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of(true, "[2,5,6,0,0,1,2]", 5),
            Arguments.of(true, "[2,5,6,0,0,1,2]", 6),
            Arguments.of(true, "[2,5,6,0,0,1,2]", 2),
            Arguments.of(false, "[2,5,6,0,0,1,2]", 3),
            Arguments.of(true, "[2,5,6,0,0,1,2]", 0)
        );
    }
}