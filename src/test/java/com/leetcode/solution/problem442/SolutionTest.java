package com.leetcode.solution.problem442;

import com.leetcode.converter.IntArrayConverter;
import com.leetcode.converter.IntegerListConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2022-05-08 02:05:49
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(
        @ConvertWith(IntegerListConverter.class) List<Integer> expected,
        @ConvertWith(IntArrayConverter.class) int[] nums) {
        expected.sort(Integer::compareTo);
        List<Integer> result = new Solution().findDuplicates(nums);
        result.sort(Integer::compareTo);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of("[10,1]", "[10,2,5,10,9,1,1,4,3,7]"),
            Arguments.of("[2,3]", "[4,3,2,7,8,2,3,1]"),
            Arguments.of("[1]", "[1,1,2]"),
            Arguments.of("[]", "[1]")
        );
    }
}