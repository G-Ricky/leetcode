package com.leetcode.solution.problem447;

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
 * @date 2021-09-14 00:09:00
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(
        int expected,
        int[][] points) {
        Assertions.assertEquals(expected, new Solution().numberOfBoomerangs(points));
    }

    static Stream<Arguments> testSource() {
        Serializer<int[][]> serializer = new IntArray2Serializer();
        return Stream.of(
            Arguments.of(2, serializer.deserialize("[[0,0],[1,0],[2,0]]")),
            Arguments.of(2, serializer.deserialize("[[1,1],[2,2],[3,3]]")),
            Arguments.of(0, serializer.deserialize("[[1,1]]"))

        );
    }
}