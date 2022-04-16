package com.leetcode.solution.problem385;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2022-04-15 23:04:13
 */
public class SolutionTest {

    @Test
    void test() {
        NestedInteger nestedInteger = new Solution().deserialize("-1000");
        System.out.println(nestedInteger);
    }

}