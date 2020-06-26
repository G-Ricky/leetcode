package com.leetcode.solution.problem120;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-06-26 23:09:04
 */
public class SolutionTestFactory {

    static Stream<Object> test() {
        List<List<Integer>> input = Arrays.asList(
            Collections.singletonList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );

        return Stream.of(
            Arguments.of(11, input)
        );
    }
}
