package com.leetcode.solution.problem130;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-08-12 00:10:30
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(char[][] result, char[][] board) {
        Solution solution = new Solution();
        solution.solve(board);
        Assertions.assertArrayEquals(result, board);
    }

    static Stream<Arguments> testSource() {
        char[][] result1 = new char[][]{
            {'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        char[][] board1 = new char[][]{
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        char[][] result2 = new char[][] {

        };

        return Stream.of(
            Arguments.of(result1, board1)
        );
    }
}
