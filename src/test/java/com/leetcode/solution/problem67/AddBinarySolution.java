package com.leetcode.solution.problem67;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ricky
 * @date 2020-06-23 02:17:03
 */
public class AddBinarySolution {

    @Test
    public void test() {
        Solution solution = new Solution();
        Assertions.assertEquals("100", solution.addBinary("11", "1"));
        Assertions.assertEquals("10101", solution.addBinary("1010", "1011"));
    }
}
