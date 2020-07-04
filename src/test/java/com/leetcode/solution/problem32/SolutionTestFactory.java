package com.leetcode.solution.problem32;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-07-04 21:19:49
 */
public class SolutionTestFactory {

    static Stream<Arguments> test() {
        return Stream.of(
            Arguments.of(2, "(()"),
            Arguments.of(4, ")()())"),
            Arguments.of(2, "()(()"),
            Arguments.of(6, "()(()()()")
        );
    }
}
