package com.leetcode.solution.problem338;

import com.leetcode.converter.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Ricky
 * @date 2020-06-22 01:56:42
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem338.SolutionTestFactory#test")
    public void test(
        @ConvertWith(IntArrayConverter.class) int[] result,
        int num
    ) {
        Solution solution = new Solution();
        Assertions.assertArrayEquals(result, solution.countBits(num));
    }
}
