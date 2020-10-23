package com.leetcode.core.params.config;

import java.util.List;

/**
 * @author Ricky
 * @date 2020-10-24 01:06:22
 */
public class Root {

    private String version;

    private String mode;

    private String resultHandler;

    private List<TestCase> testCase;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getResultHandler() {
        return resultHandler;
    }

    public void setResultHandler(String resultHandler) {
        this.resultHandler = resultHandler;
    }

    public List<TestCase> getTestCase() {
        return testCase;
    }

    public void setTestCase(List<TestCase> testCase) {
        this.testCase = testCase;
    }
}
