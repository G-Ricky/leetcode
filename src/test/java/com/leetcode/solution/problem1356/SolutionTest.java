package com.leetcode.solution.problem1356;

import com.leetcode.converter.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-11-06 00:46:24
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(
        @ConvertWith(IntArrayConverter.class) int[] expected,
        @ConvertWith(IntArrayConverter.class) int[] arr
    ) {
        Assertions.assertArrayEquals(expected, new Solution().sortByBits(arr));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of("[0,1,2,4,8,3,5,6,7]", "[0,1,2,3,4,5,6,7,8]"),
            Arguments.of("[1,2,4,8,16,32,64,128,256,512,1024]", "[1024,512,256,128,64,32,16,8,4,2,1]")
        );
    }
}
