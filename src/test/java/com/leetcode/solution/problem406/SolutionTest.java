package com.leetcode.solution.problem406;

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
 * @date 2020-11-16 23:35:57
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(
        int[][] expected,
        int[][] people
    ) {
        Assertions.assertArrayEquals(expected, new Solution().reconstructQueue(people));
    }

    static Stream<Arguments> testSource() {
        Serializer<int[][]> serializer = new IntArray2Serializer();
        return Stream.of(
            Arguments.of(serializer.deserialize("[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]"), serializer.deserialize("[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]"))
        );
    }
}
