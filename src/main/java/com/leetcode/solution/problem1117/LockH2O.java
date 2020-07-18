package com.leetcode.solution.problem1117;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * （未完成）
 * @author Ricky
 * @date 2020-07-19 01:45:54
 */
public class LockH2O {

    private Lock hydrogenLock = new ReentrantLock();

    private Lock oxygenLock = new ReentrantLock();

    private Condition hydrogenCondition = hydrogenLock.newCondition();

    private Condition oxygenCondition = oxygenLock.newCondition();

    private AtomicInteger hydrogenCount = new AtomicInteger(0);

    private AtomicInteger oxygenCount = new AtomicInteger(0);

    public LockH2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenLock.lock();
        try {
            if (hydrogenCount.get() >= 2 && oxygenCount.get() >= 1) {
                hydrogenCount.decrementAndGet();
                hydrogenCount.decrementAndGet();
                oxygenCount.decrementAndGet();
                oxygenCondition.signal();
            } else if (hydrogenCount.get() >= 2) {
                hydrogenCondition.await();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            hydrogenCount.incrementAndGet();
        } finally {
            hydrogenLock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenLock.lock();
        try {
            if (hydrogenCount.get() >= 2 && oxygenCount.get() >= 1) {
                hydrogenCount.decrementAndGet();
                hydrogenCount.decrementAndGet();
                oxygenCount.decrementAndGet();
                hydrogenCondition.signal();
                hydrogenCondition.signal();
            } else if (oxygenCount.get() >= 1) {
                oxygenCondition.await();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            oxygenCount.incrementAndGet();
        } finally {
            oxygenLock.unlock();
        }
    }
}
