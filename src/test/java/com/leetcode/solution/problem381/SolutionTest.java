package com.leetcode.solution.problem381;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ricky
 * @date 2020-10-31 23:29:26
 */
public class SolutionTest {

    @Test
    void test() {
        RandomizedCollection collection = new RandomizedCollection();
        Assertions.assertTrue(collection.insert(1));
        Assertions.assertFalse(collection.insert(1));
        Assertions.assertTrue(collection.insert(2));
        System.out.println(collection.getRandom());
        Assertions.assertTrue(collection.remove(1));
        System.out.println(collection.getRandom());
    }

    @Test
    void test1() {
        RandomizedCollection collection = new RandomizedCollection();
        Assertions.assertTrue(collection.insert(0));
        Assertions.assertTrue(collection.insert(1));
        Assertions.assertTrue(collection.remove(0));
        Assertions.assertTrue(collection.insert(2));
        Assertions.assertTrue(collection.remove(1));
        System.out.println(collection.getRandom());
    }

    @Test
    void test2() {
        RandomizedCollection collection = new RandomizedCollection();
        Assertions.assertTrue(collection.insert(0));
        Assertions.assertTrue(collection.remove(0));
        Assertions.assertTrue(collection.insert(-1));
        Assertions.assertFalse(collection.remove(0));
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
        System.out.println(collection.getRandom());
    }
}
