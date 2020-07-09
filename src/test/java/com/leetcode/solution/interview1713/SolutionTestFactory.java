package com.leetcode.solution.interview1713;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-07-09 22:52:26
 */
public class SolutionTestFactory {

    static Stream<Arguments> test() {
        return Stream.of(
            Arguments.of(7, new String[]{ "looked","just","like","her","brother"}, "jesslookedjustliketimherbrother"),
            Arguments.of(0, new String[]{ "looked","just","like","her","brother", "jesslookedjustliketimherbrother"}, "jesslookedjustliketimherbrother"),
            Arguments.of(0, new String[]{ "jess", "looked","just","like", "tim","her","brother", "jesslookedjustliketimherbrother"}, "jesslookedjustliketimherbrother"),
            Arguments.of(6, new String[]{ "looked","just","like","her","brother", "liket"}, "jesslookedjustliketimherbrother"),
            Arguments.of(0, new String[]{ "looked","just","like","her","brother", "liket"}, ""),
            Arguments.of(31, new String[]{}, "jesslookedjustliketimherbrother")
        );
    }
}
