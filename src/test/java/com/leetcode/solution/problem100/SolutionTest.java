package com.leetcode.solution.problem100;

import com.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ricky
 * @date 2020-06-24 00:22:17
 */
public class SolutionTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode[] nodes = new TreeNode[16];
        nodes[0] = new TreeNode(1);
        nodes[1] = new TreeNode(2);
        nodes[2] = new TreeNode(3);
        nodes[3] = new TreeNode(1);
        nodes[4] = new TreeNode(2);
        nodes[5] = new TreeNode(3);
        nodes[6] = new TreeNode(1);
        nodes[7] = new TreeNode(2);
        nodes[8] = new TreeNode(1);
        nodes[9] = new TreeNode(2);
        nodes[10] = new TreeNode(1);
        nodes[11] = new TreeNode(2);
        nodes[12] = new TreeNode(1);
        nodes[13] = new TreeNode(1);
        nodes[14] = new TreeNode(1);
        nodes[15] = new TreeNode(2);
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];
        nodes[3].left = nodes[4];
        nodes[3].right = nodes[5];
        nodes[6].left = nodes[7];
        nodes[8].right = nodes[9];
        nodes[10].left = nodes[11];
        nodes[10].right = nodes[12];
        nodes[13].left = nodes[14];
        nodes[13].right = nodes[15];

        Assertions.assertTrue(solution.isSameTree(nodes[0], nodes[3]));
        Assertions.assertFalse(solution.isSameTree(nodes[6], nodes[8]));
        Assertions.assertFalse(solution.isSameTree(nodes[10], nodes[13]));
    }
}
