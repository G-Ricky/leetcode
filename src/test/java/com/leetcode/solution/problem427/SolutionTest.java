package com.leetcode.solution.problem427;

import com.leetcode.serializer.IntArray2Serializer;
import com.leetcode.serializer.Serializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2022-04-29 22:04:54
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(int[][] grid) {
        Node result = new Solution().construct(grid);
    }

    static Stream<Arguments> testSource() {
        Serializer<int[][]> serializer = new IntArray2Serializer();
        return Stream.of(
            Arguments.of((Object) serializer.deserialize("[[1,1,0,0],[0,0,1,1],[1,1,0,0],[0,0,1,1]]"))
        );
    }
}