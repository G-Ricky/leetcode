package com.leetcode.solution.problem173;

import com.leetcode.TreeNode;
import com.leetcode.serializer.Serializer;
import com.leetcode.serializer.TreeSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ricky
 * @date 2021-03-28 01:03:53
 */
public class SolutionTest {

    @Test
    void test() {
        testCase1();
    }

    @SuppressWarnings("SimplifiableAssertion")
    private void testCase1() {
        Serializer<TreeNode> serializer = new TreeSerializer();
        TreeNode treeNode = serializer.deserialize("[7, 3, 15, null, null, 9, 20]");
        BSTIterator bstIterator = new BSTIterator(treeNode);
        Assertions.assertEquals(3, bstIterator.next()); // 返回 3
        Assertions.assertEquals(7, bstIterator.next()); // 返回 7
        Assertions.assertEquals(true, bstIterator.hasNext()); // 返回 True
        Assertions.assertEquals(9, bstIterator.next()); // 返回 9
        Assertions.assertEquals(true, bstIterator.hasNext()); // 返回 True
        Assertions.assertEquals(15, bstIterator.next()); // 返回 15
        Assertions.assertEquals(true, bstIterator.hasNext()); // 返回 True
        Assertions.assertEquals(20, bstIterator.next()); // 返回 20
        Assertions.assertEquals(false, bstIterator.hasNext()); // 返回 False
    }
}