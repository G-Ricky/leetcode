package com.leetcode.solution.problem321;

import com.leetcode.ListNode;
import com.leetcode.converter.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-12-02 00:12:00
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(
        @ConvertWith(IntArrayConverter.class) int[] expected,
        @ConvertWith(IntArrayConverter.class) int[] nums1,
        @ConvertWith(IntArrayConverter.class) int[] nums2,
        int k
    ) {
        Assertions.assertArrayEquals(expected, new Solution().maxNumber(nums1, nums2, k));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of("[9,8,4,6,5]", "[3,4,6,5]", "[9,1,2,5,8]", 5),
            Arguments.of("[9,8,6,5,3]", "[3,4,6,5]", "[9,1,2,5,8,3]", 5),
            Arguments.of("[6,7,6,0,4]", "[6,7]", "[6,0,4]", 5),
            Arguments.of("[9,8,9]", "[3,9]", "[8,9]", 3)
        );
    }
}
