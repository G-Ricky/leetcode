package com.leetcode.solution.problem1797;

import org.junit.jupiter.api.Test;

/**
 * @author Ricky
 * @date 2023-02-09 23:02:52
 */
public class SolutionTest {

    @Test
    void test() {
        AuthenticationManager authenticationManager = new AuthenticationManager(13);
        authenticationManager.renew("ajvy",1);
        authenticationManager.countUnexpiredTokens(3);
        authenticationManager.countUnexpiredTokens(4);
        authenticationManager.generate("fuzxq",5);
        authenticationManager.generate("izmry",7);
        authenticationManager.renew("puv",12);
        authenticationManager.generate("ybiqb",13);
        authenticationManager.generate("gm",14);
        authenticationManager.countUnexpiredTokens(15);
        authenticationManager.countUnexpiredTokens(18);
        authenticationManager.countUnexpiredTokens(19);
        authenticationManager.renew("ybiqb",21);
        authenticationManager.countUnexpiredTokens(23);
        authenticationManager.countUnexpiredTokens(25);
        authenticationManager.countUnexpiredTokens(26);
        authenticationManager.generate("aqdm",28);
        authenticationManager.countUnexpiredTokens(29);
        authenticationManager.renew("puv",30);
    }
}