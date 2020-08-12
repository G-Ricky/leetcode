package com.leetcode.solution.problem43;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.Arguments;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-08-13 02:54:11
 */
public class SolutionPerformanceTest {

    private static final List<Param> params = new LinkedList<>();

    @BeforeAll
    static void beforeAll() {
        Stream<Arguments> stream = SolutionTest.testSource();
        List<Param> params = stream
            .map(arg -> {
                Param param = new Param();
                Object[] objects = arg.get();
                param.result = (String) objects[0];
                param.num1 = (String) objects[1];
                param.num2 = (String) objects[2];
                return param;
            })
            .collect(Collectors.toList());

        SolutionPerformanceTest.params.addAll(params);
    }

    @JunitPerfConfig(duration = 2000, warmUp = 1000)
    void testStandardPerformance() {
        for (Param param : params) {
            Assertions.assertEquals(
                param.result,
                new StandardSolution().multiply(param.num1, param.num2)
            );
        }
    }

    @JunitPerfConfig(duration = 2000, warmUp = 1000)
    void testOfficialPerformance() {
        for (Param param : params) {
            Assertions.assertEquals(
                param.result,
                new OfficialSolution().multiply(param.num1, param.num2)
            );
        }
    }

    static class Param {
        public String num1;

        public String num2;

        public String result;
    }
}
