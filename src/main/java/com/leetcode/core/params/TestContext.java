package com.leetcode.core.params;

import org.junit.jupiter.api.Assertions;

/**
 * @author Ricky
 * @date 2020-10-24 00:45:04
 */
public class TestContext {

    public void test(Object source) {
        Assertions.assertNotNull(source);
        Class<?> clazz = source.getClass();
//        clazz.getDeclaredMethod(method, );
    }
}
