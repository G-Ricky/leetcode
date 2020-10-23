package com.leetcode.core.params;

import org.apiguardian.api.API;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.*;

import static org.apiguardian.api.API.Status.EXPERIMENTAL;

/**
 * 参数化测试，yaml 数据来源
 *
 * @author Ricky
 * @date 2020-10-24 00:22:19
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@API(status = EXPERIMENTAL, since = "5.0")
@ArgumentsSource(YamlArgumentsProvider.class)
public @interface LeetCodeSource {

    String value() default "testCase.yaml";

    String target();
}
