package com.leetcode.solution.problem1129;

import com.leetcode.converter.IntArray2Converter;
import com.leetcode.converter.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2023-02-02 21:02:40
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(
        @ConvertWith(IntArrayConverter.class) int[] expected,
        int n,
        @ConvertWith(IntArray2Converter.class) int[][] redEdges,
        @ConvertWith(IntArray2Converter.class) int[][] blueEdges
    ) {
        Assertions.assertArrayEquals(expected, new Solution().shortestAlternatingPaths(n, redEdges, blueEdges));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of("[0,-1,4,1,-1,2]", 6, "[[4,1],[3,5],[5,2],[1,4],[4,2],[0,0],[2,0],[1,1]]", "[[5,5],[5,0],[4,4],[0,3],[1,0]]"),
            Arguments.of("[0,-1,1,1,3,1,1,2]", 8, "[[3,2],[0,3],[1,3],[3,6],[2,5],[5,0],[5,3],[5,6],[7,3]]", "[[2,4],[6,6],[3,2],[6,0],[4,4],[0,2],[2,5],[4,5],[5,0],[0,3],[5,6],[3,7],[3,5],[0,6],[7,0],[7,1],[1,0],[7,4],[0,5]]"),
            Arguments.of("[0,1,2]", 3, "[[0,1]]", "[[1,2]]"),
            Arguments.of("[0,1,-1]", 3, "[[0,1],[1,2]]", "[]"),
            Arguments.of("[0,1,-1]", 3, "[[0,1]]", "[[2,1]]"),
            Arguments.of("[0,-1,-1]", 3, "[[1,0]]", "[[2,1]]"),
            Arguments.of("[0,1,1]", 3, "[[0,1],[0,2]]", "[[1,0]]")
        );
    }
}