package com.leetcode.solution.problem338;

import com.leetcode.serializer.IntArraySerializer;
import com.leetcode.serializer.Serializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ricky
 * @date 2020-06-22 01:56:42
 */
public class CountBitsSolution {

    @Test
    public void test() {
        Solution solution = new Solution();
        Serializer<int[]> serializer = new IntArraySerializer();
        Assertions.assertArrayEquals(solution.countBits(2), serializer.deserialize("[0,1,1]"));
        Assertions.assertArrayEquals(solution.countBits(5), serializer.deserialize("[0,1,1,2,1,2]"));
        Assertions.assertArrayEquals(solution.countBits(20), serializer.deserialize("[0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1,2,2,3,2]"));
    }
}
