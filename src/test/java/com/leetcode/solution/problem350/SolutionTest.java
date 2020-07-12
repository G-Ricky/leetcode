package com.leetcode.solution.problem350;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;

/**
 * @author Ricky
 * @date 2020-07-13 00:28:54
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem350.SolutionTestFactory#test")
    void test(int[] result, int[] nums1, int[] nums2) {
        int[] actualResult = new Solution().intersect(nums1, nums2);
        Arrays.sort(result);
        Arrays.sort(actualResult);
        Assertions.assertArrayEquals(result, actualResult);
    }

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem350.SolutionTestFactory#test")
    void testSortedSolution(int[] result, int[] nums1, int[] nums2) {
        int[] actualResult = new SortedSolution().intersect(nums1, nums2);
        Arrays.sort(result);
        Arrays.sort(actualResult);
        Assertions.assertArrayEquals(result, actualResult);
    }
}
