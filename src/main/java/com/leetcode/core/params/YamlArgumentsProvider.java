package com.leetcode.core.params;

import com.leetcode.core.params.config.Root;
import com.leetcode.serializer.ListNodeSerializer;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.stream.Stream;

/**
 * yaml 参数解析
 *
 * @author Ricky
 * @date 2020-10-24 00:24:25
 */
public class YamlArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<LeetCodeSource> {

    private String testCaseFile;

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        Yaml yaml = new Yaml();
        InputStream in = this.getClass().getResourceAsStream("/solution/problem234/testCase.yaml");
        Root root = yaml.loadAs(in, Root.class);
        return Stream.of(
            Arguments.of(new ListNodeSerializer().deserialize("[1,2,1]"))
        );
    }

    @Override
    public void accept(LeetCodeSource leetCodeSource) {
        testCaseFile = leetCodeSource.value();
    }
}
