package com.leetcode.solution.problem1631;

import com.leetcode.converter.IntArrayConverter;
import com.leetcode.serializer.IntArray2Serializer;
import com.leetcode.serializer.Serializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2021-01-29 23:01:57
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(
        int expected,
        int[][] heights) {
        Assertions.assertEquals(expected, new Solution().minimumEffortPath(heights));
    }

    static Stream<Arguments> testSource() {
        Serializer<int[][]> serializer = new IntArray2Serializer();
        return Stream.of(
            Arguments.of(2, serializer.deserialize("[[1,2,2],[3,8,2],[5,3,5]]")),
            Arguments.of(5, serializer.deserialize("[[4,3,4,10,5,5,9,2],[10,8,2,10,9,7,5,6],[5,8,10,10,10,7,4,2],[5,1,3,1,1,3,1,9],[6,4,10,6,10,9,4,6]]"))
        );
    }
}
