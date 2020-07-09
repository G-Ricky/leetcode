package com.leetcode.solution.problem44;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-07-05 22:14:46
 */
public class SolutionTestFactory {

    static Stream<Arguments> test() {
        return Stream.of(
            Arguments.of(false, "aa", "a"),
            Arguments.of(true, "aa", "*"),
            Arguments.of(false, "cb", "?a"),
            Arguments.of(true, "adceb", "*a*b"),
            Arguments.of(false, "acdcb", "a*c?b"),
            Arguments.of(
                true,
                "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
                "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"
            ),
            Arguments.of(
                false,
                "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"
            )
        );
    }
}
