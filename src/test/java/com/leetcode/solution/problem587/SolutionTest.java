package com.leetcode.solution.problem587;

import com.leetcode.serializer.IntArray2Serializer;
import com.leetcode.serializer.Serializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2022-04-23 20:04:09
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(int[][] expected, int[][] trees) {
        int[][] sortedExpected = sort(expected);
        int[][] sortedResult = sort(new Solution().outerTrees(trees));
        Assertions.assertArrayEquals(sortedExpected, sortedResult);
    }

    private int[][] sort(int[][] array) {
        int n = array.length;
        int m = n > 0
            ? array[0].length
            : 0;
        int[][] sorted = new int[n][m];
        System.arraycopy(array, 0, sorted, 0, n);
        Arrays.sort(sorted, (o1, o2) ->
            o1[0] == o2[0]
                ? (Integer.compare(o1[1], o2[1]))
                : (o1[0] > o2[0] ? 1 : -1)
        );
        return sorted;
    }

    static Stream<Arguments> testSource() {
        Serializer<int[][]> serializer = new IntArray2Serializer();
        return Stream.of(
            Arguments.of(serializer.deserialize("[[1,1],[2,0],[4,2],[3,3],[2,4]]"), serializer.deserialize("[[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]")),
            Arguments.of(serializer.deserialize("[[1,2],[2,2],[4,2]]"), serializer.deserialize("[[1,2],[2,2],[4,2]]"))
        );
    }
}