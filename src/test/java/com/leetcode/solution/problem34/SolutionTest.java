package com.leetcode.solution.problem34;

import com.leetcode.converter.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-12-01 00:12:10
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(
        @ConvertWith(IntArrayConverter.class) int[] expected,
        @ConvertWith(IntArrayConverter.class) int[] nums,
        int target
    ) {
        Assertions.assertArrayEquals(expected, new Solution().searchRange(nums, target));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of("[3,4]", "[5,7,7,8,8,10]", 8),
            Arguments.of("[-1,-1]", "[5,7,7,8,8,10]", 6),
            Arguments.of("[-1,-1]", "[]", 0)
        );
    }
}
