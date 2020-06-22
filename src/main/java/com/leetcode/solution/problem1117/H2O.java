package com.leetcode.solution.problem1117;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * H2O 生成
 *
 * @author Ricky
 * @date 2020-06-19 20:17:35
 */
public class H2O {


    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(0);

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }



    private static final Runnable runHydrogen = () -> System.out.print('H');

    private static final Runnable runOxygen = () -> System.out.print('O');

    public static void main(String[] args) {
//        String input = "OOHHHH";
//        String input = "OHOOHOHHHHOHHOHHHH";
//        final Queue<Character> queue = new LinkedList<>();
//
//        for (int i = 0; i < input.length(); ++i) {
//            queue.offer(input.charAt(i));
//        }
//
//        H2O h2O = new H2O();
//        Thread hydrogenThread = new Thread(() -> {
//            try {
//                while (!queue.isEmpty()) {
//                    synchronized (queue) {
//                        if (queue.peek() != 'H') {
//                            continue;
//                        }
//                        queue.poll();
//                    }
//                    h2O.hydrogen(runHydrogen);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "hydrogenThread");
//        Thread oxygenThread = new Thread(() -> {
//            try {
//                while (!queue.isEmpty()) {
//                    synchronized (queue) {
//                        if (queue.peek() != 'O') {
//                            continue;
//                        }
//                        queue.poll();
//                    }
//                    h2O.oxygen(runOxygen);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "oxygenThread");
//
//        hydrogenThread.start();
//        oxygenThread.start();
    }
}
