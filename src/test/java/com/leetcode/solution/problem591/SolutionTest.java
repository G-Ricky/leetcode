package com.leetcode.solution.problem591;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2022-05-04 00:05:09
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(boolean expected, String code) {
        Assertions.assertEquals(expected, new Solution().isValid(code));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of(true, "<DIV>This is the first line <![CDATA[<div>]]></DIV>"),
            Arguments.of(true, "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"),
            Arguments.of(false, "<A>  <B> </A>   </B>"),
            Arguments.of(false, "<DIV>  div tag is not closed  <DIV>"),
            Arguments.of(false, "<DIV>  unmatched <  </DIV>"),
            Arguments.of(false, "<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"),
            Arguments.of(false, "<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>"),
            Arguments.of(false, "<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"),
            Arguments.of(false, "<A><![CDATA[</A>]]>"),
            Arguments.of(false, "<AAAAAAAAAA></AAAAAAAAAA>")
        );
    }
}