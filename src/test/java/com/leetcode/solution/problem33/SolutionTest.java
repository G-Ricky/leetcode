package com.leetcode.solution.problem33;

import com.leetcode.converter.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2021-03-29 23:03:39
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(
        int expected,
        @ConvertWith(IntArrayConverter.class) int[] nums,
        int target
    ) {
        Assertions.assertEquals(expected, new Solution().search(nums, target));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of(4, "[4,5,6,7,0,1,2]", 0),
            Arguments.of(-1, "[4,5,6,7,0,1,2]", 3),
            Arguments.of(-1, "[1]", 0),
            Arguments.of(-1, "[1,3]", 2),
            Arguments.of(-1, "[1,3]", 0),
            Arguments.of(-1, "[1,3]", 4),
            Arguments.of(1, "[1,3]", 3),
            Arguments.of(0, "[1,3]", 1),
            Arguments.of(-1, "[1,3]", 2)
        );
    }
}