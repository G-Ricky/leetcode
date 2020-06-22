package com.leetcode;

import com.leetcode.solution.interview46.TestCases;
import com.leetcode.solution.problem1013.Tester;
import com.leetcode.solution.problem703.TestCases2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Package, List<Class<?>>> PACKAGE_CLASSES_MAP = new HashMap<>();

    public static void main(String[] args) {
        com.leetcode.solution.problem14.TestCases.test();
        com.leetcode.solution.problem110.Tester.test();
        com.leetcode.solution.problem121.Tester.test();
        com.leetcode.solution.problem121.Tester.testStandard();
        com.leetcode.solution.problem128.TestCases.test();
        com.leetcode.solution.problem238.Tester.test();
        com.leetcode.solution.problem239.TestCases2.test();
        com.leetcode.solution.problem300.Tester.test();
        com.leetcode.solution.problem543.Tester.test();
        com.leetcode.solution.problem695.Tester.test();
        com.leetcode.solution.problem703.TestCases.test();
        TestCases2.test();
        com.leetcode.solution.problem990.TestCases.test();
//        com.leetcode.problem880.Tester.test();
        Tester.test();
//        com.leetcode.problem1235.Tester.test();
        com.leetcode.solution.interview29.Tester.test();
        TestCases.test();
    }

    private void test() throws Exception {
        String rootPackage = "com.leetcode";

        List<Class<?>> classes = PackageScan.scanClass(rootPackage);
        List<Method> methods = new LinkedList<>();
        for (Class<?> clazz : classes) {
            // 添加到包
            List<Class<?>> packageClasses = PACKAGE_CLASSES_MAP.get(clazz.getPackage());
            if (packageClasses == null) {
                packageClasses = new LinkedList<>();
            }
            packageClasses.add(clazz);

            if ("TestCases".equals(clazz.getSimpleName())) {
                // 添加用例
                continue;
            }

            if (clazz.getPackage().getName().equals(rootPackage)) {
                continue;
            }

            if (clazz.isAnnotationPresent(LeetCode.class)) {
                Method[] clazzMethods = clazz.getDeclaredMethods();
                int publicCount = 0;
                Method invokeMethod = null;
                for (Method clazzMethod : clazzMethods) {
                    if (Modifier.isPublic(clazzMethod.getModifiers())) {
                        ++publicCount;
                        if (publicCount > 1) {
                            throw new RuntimeException("超过 1 个 public");
                        }
                        invokeMethod = clazzMethod;
                    }
                }
                if (invokeMethod == null) {
                    throw new RuntimeException("没用 public");
                }
                Object instance = clazz.newInstance();

                invokeMethod.invoke(instance);
            }
        }
    }
}