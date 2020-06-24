package com.leetcode.solution.problem67;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-06-24 13:43:15
 */
public class SolutionTestFactory {

    public static Stream<Object[]> test() {
        return Stream.of(
            new Object[]{"100", "11", "1"},
            new Object[]{"10101", "1010", "1011"}
        );
    }
}
