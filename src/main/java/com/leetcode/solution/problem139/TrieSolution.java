package com.leetcode.solution.problem139;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单词拆分
 *
 * @author Ricky
 * @date 2020-06-25 16:23:36
 */
public class TrieSolution {
    private TrieNode root;

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        this.root = root;
        for (String word : wordDict) {
            insertWord(root, word);
        }

        return tryMatch(root, s, 0);
    }

    private boolean tryMatch(TrieNode current, String word, int i) {
        Map<Character, TrieNode> children = current.children;

        for (Map.Entry<Character, TrieNode> entry : children.entrySet()) {
            char ch = word.charAt(i);
            if (i == word.length() - 1 && entry.getValue().isWord) {
                return true;
            }
            TrieNode node = children.get(ch);
            if (node.isWord && tryMatch(root, word, i + 1)) {
                return true;
            }
            if (entry.getKey() == ch) {
                if (tryMatch(node, word, i + 1)) {
                    return true;
                }
            }
            ++i;
        }

        return false;
    }

    private void insertWord(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            if (node.children == null) {
                node.children = new HashMap<>(16);
            }
            char ch = word.charAt(i);
            TrieNode current = node.children.containsKey(ch)
                ? node.children.get(ch)
                : new TrieNode(ch);
            current.isWord = current.isWord || i == word.length() - 1;
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, current);
            }
            node = current;
        }
    }

    public static class TrieNode {
        public char val;

        public boolean isWord;

        public Map<Character, TrieNode> children;

        public TrieNode() {

        }

        public TrieNode(char val) {
            this.val = val;
        }
    }
}
