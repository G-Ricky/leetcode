package com.leetcode.solution.problem547;

import com.leetcode.serializer.IntArray2Serializer;
import com.leetcode.serializer.Serializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2021-01-07 23:01:54
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(int expected, int[][] isConnected) {
        Assertions.assertEquals(expected, new Solution().findCircleNum(isConnected));
    }

    static Stream<Arguments> testSource() {
        Serializer<int[][]> serializer = new IntArray2Serializer();
        return Stream.of(
            Arguments.of(2, serializer.deserialize("[[1,1,0],[1,1,0],[0,0,1]]")),
            Arguments.of(3, serializer.deserialize("[[1,0,0],[0,1,0],[0,0,1]]")),
            Arguments.of(2, serializer.deserialize("[[1,1,1,0,0,0],[1,1,1,0,0,0],[1,1,1,1,0,0],[0,0,1,1,0,0],[0,0,0,0,1,1],[0,0,0,0,1,1]]")),
            Arguments.of(1, serializer.deserialize("[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]"))
        );
    }
}
