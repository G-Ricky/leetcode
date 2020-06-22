package com.leetcode.solution.problem990;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Ricky
 * @date 2020-06-09 00:03:52
 */
public class TestCases {

    public static void test() {
        Solution solution = new Solution();
        for (TestCase testCase : testCases()) {
            assert Objects.equals(solution.equationsPossible(testCase.input.equations), testCase.output);
        }
    }

    private static List<TestCase> testCases() {
        List<TestCase> testCases = new LinkedList<>();

        testCases.add(new TestCase(
            new Input(new String[]{"a!=a"}),
            false
        ));

        testCases.add(new TestCase(
            new Input(new String[]{"a!=b"}),
            true
        ));
        testCases.add(new TestCase(
            new Input(new String[]{"a==b"}),
            true
        ));
        testCases.add(new TestCase(
            new Input(new String[]{"a==a"}),
            true
        ));
        testCases.add(new TestCase(
            new Input(new String[]{"a==b", "b!=a"}),
            false
        ));
        testCases.add(new TestCase(
            new Input(new String[]{"b==a", "a==b"}),
            true
        ));
        testCases.add(new TestCase(
            new Input(new String[]{"a==b", "b==c", "a==c"}),
            true
        ));
        testCases.add(new TestCase(
            new Input(new String[]{"a==b", "b!=c", "c==a"}),
            false
        ));
        testCases.add(new TestCase(
            new Input(new String[]{"c==c", "b==d", "x!=z"}),
            true
        ));
        testCases.add(new TestCase(
            new Input(new String[]{"e!=c","b!=b","b!=a","e==d"}),
            false
        ));

        return testCases;
    }

    public static class TestCase {

        public Input input;

        public Boolean output;

        public TestCase(Input input, Boolean output) {
            this.input = input;
            this.output = output;
        }
    }

    public static class Input {

        public String[] equations;

        public Input(String[] equations) {
            this.equations = equations;
        }
    }
}
