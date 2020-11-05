package com.leetcode.solution.problem127;

import java.util.*;

/**
 * 单词接龙
 *
 * @author Ricky
 * @date 2020-11-05 23:31:49
 */
public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() < 1) {
            return 0;
        }
        boolean hasEnd = false;
        for (String word : wordList) {
            if (endWord.equals(word)) {
                hasEnd = true;
                break;
            }
        }
        if (!hasEnd) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Map<String, Set<String>> patternMap = new HashMap<>(wordList.size());
        List<String> newWordList = new ArrayList<>(wordList.size() + 1);
        newWordList.addAll(wordList);
        newWordList.add(beginWord);
        for (String word : newWordList) {
            for (int i = 0; i < word.length(); ++i) {
                String pattern = word.substring(0, i) + "#" + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new HashSet<>())
                    .add(word);
            }
        }
        // 合并
        Map<String, Set<String>> graph = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : patternMap.entrySet()) {
            for (String word1 : entry.getValue()) {
                for (String word2 : entry.getValue()) {
                    if (!word1.equals(word2)) {
                        graph.computeIfAbsent(word1, k -> new HashSet<>())
                            .add(word2);
                        graph.computeIfAbsent(word2, k -> new HashSet<>())
                            .add(word1);
                    }
                }
            }
        }
        Queue<String> queue = new LinkedList<>();
        Queue<String> nextLevel = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                String current = queue.poll();
                if (current.equals(endWord)) {
                    return level;
                }
                Set<String> next;
                if ((next = graph.get(current)) == null || next.isEmpty()) {
                    return 0;
                }
                for (String word : graph.get(current)) {
                    if (!visited.contains(word)) {
                        nextLevel.offer(word);
                        visited.add(word);
                    }
                }
            }
            ++level;
            Queue<String> temp = queue;
            queue = nextLevel;
            nextLevel = temp;
        }
        return 0;
    }
}
