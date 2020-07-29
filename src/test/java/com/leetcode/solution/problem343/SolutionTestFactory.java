package com.leetcode.solution.problem343;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-07-30 00:45:58
 */
public class SolutionTestFactory {

    static Stream<Arguments> test() {
        return Stream.of(
            Arguments.of(1, 2),
            Arguments.of(36, 10)
        );
    }
}
