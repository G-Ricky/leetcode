package com.leetcode.solution.problem31;

import com.leetcode.converter.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-11-10 22:53:57
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(
        @ConvertWith(IntArrayConverter.class) int[] expected,
        @ConvertWith(IntArrayConverter.class) int[] nums
    ) {
        new Solution().nextPermutation(nums);
        Assertions.assertArrayEquals(expected, nums);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of("[1,3,2]", "[1,2,3]"),
            Arguments.of("[1,2,3]", "[3,2,1]"),
            Arguments.of("[1,5,1]", "[1,1,5]"),
            Arguments.of("[1,2,3,2]", "[1,2,2,3]"),
            Arguments.of("[3,1,4,4]", "[1,4,4,3]"),
            Arguments.of("[1,2,3,5]", "[5,3,2,1]"),
            Arguments.of("[1,3,2,2]", "[1,2,3,2]"),
            Arguments.of("[3,1,2]", "[2,3,1]"),
            Arguments.of("[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]", "[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]")
        );
    }
}
