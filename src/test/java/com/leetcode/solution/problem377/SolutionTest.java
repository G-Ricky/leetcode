package com.leetcode.solution.problem377;

import com.leetcode.converter.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2021-04-24 14:04:01
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(int expected, @ConvertWith(IntArrayConverter.class) int[] nums, int target) {
        Assertions.assertEquals(expected, new Solution().combinationSum4(nums, target));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of(7, "[1,2,3]", 4),
            Arguments.of(0, "[9]", 3),
            Arguments.of(181997601, "[1,2,3]", 32)
        );
    }
}