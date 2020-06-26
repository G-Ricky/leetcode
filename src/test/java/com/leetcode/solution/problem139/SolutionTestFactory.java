package com.leetcode.solution.problem139;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-06-25 17:42:55
 */
public class SolutionTestFactory {

    static Stream<Arguments> test() {
        return Stream.of(
            Arguments.of(true, "leetcode", Arrays.asList("leet", "code")),
            Arguments.of(true, "applepenapple", Arrays.asList("apple", "pen")),
            Arguments.of(false, "catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")),
            Arguments.of(true, "catstorm", Arrays.asList("cats", "term", "storm", "cat"))
        );
    }
}
