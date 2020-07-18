package com.leetcode.solution.problem1117;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Ricky
 * @date 2020-07-19 01:37:22
 */
public class H2OProxy {

    private Object h2o;

    private final Method invokeHydrogen;

    private final Method invokeOxygen;

    private H2OProxy(Object h2o) {
        Class<?> clazz = h2o.getClass();
        this.h2o = h2o;
        try {
            this.invokeHydrogen = clazz.getMethod("hydrogen", Runnable.class);
            this.invokeOxygen = clazz.getMethod("oxygen", Runnable.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        try {
            this.invokeHydrogen.invoke(this.h2o, releaseHydrogen);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try {
            this.invokeOxygen.invoke(this.h2o, releaseOxygen);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static H2OProxy of(Object h2o) {
        return new H2OProxy(h2o);
    }
}
