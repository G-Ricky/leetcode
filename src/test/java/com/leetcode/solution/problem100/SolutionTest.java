package com.leetcode.solution.problem100;

import com.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Ricky
 * @date 2020-06-24 00:22:17
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem100.SolutionTestFactory#test")
    void test(Boolean result, TreeNode tree1, TreeNode tree2) {
        Assertions.assertEquals(result, new Solution().isSameTree(tree1, tree2));
    }
}
