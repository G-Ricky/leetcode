package com.leetcode.solution.problem1117;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-07-14 23:47:23
 */
public class H2OTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(String input, H2OProxy proxy) throws InterruptedException {
        Assertions.assertTrue(input.length() > 0 && input.length() % 3 == 0);

        Thread[] threads = new Thread[input.length()];
        AtomicInteger index = new AtomicInteger(0);
        char[] output = new char[input.length()];

        Runnable outputH = () -> output[index.getAndIncrement()] = 'H';
        Runnable outputO = () -> output[index.getAndIncrement()] = 'O';

        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == 'H') {
                threads[i] = new Thread(() -> {
                    try {
                        proxy.hydrogen(outputH);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                threads[i] = new Thread(() -> {
                    try {
                        proxy.oxygen(outputO);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
            threads[i].setName("h2o-" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int mask = 7;
        for (int i = 0; i < input.length(); ++i) {
            if (i % 3 == 0) {
                Assertions.assertEquals(7, mask);
                mask = 0;
            }

            if (output[i] == 'H' && (mask & 4) == 0) {
                mask |= 4;
            } else if (output[i] == 'H') {
                mask |= 2;
            } else {
                mask |= 1;
            }
        }
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of("HOH", H2OProxy.of(new H2O())),
            Arguments.of("OOHHHH", H2OProxy.of(new H2O())),
            Arguments.of("HOHOHH", H2OProxy.of(new H2O()))
//            Arguments.of("HOH", H2OProxy.of(new LockH2O())),
//            Arguments.of("OOHHHH", H2OProxy.of(new LockH2O())),
//            Arguments.of("HOHOHH", H2OProxy.of(new LockH2O())),
//            Arguments.of("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO", H2OProxy.of(new LockH2O())),
//            Arguments.of("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH", H2OProxy.of(new LockH2O()))
        );
    }
}
