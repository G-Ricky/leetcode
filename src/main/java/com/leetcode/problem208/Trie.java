package com.leetcode.problem208;

/**
 * 实现 Trie (前缀树)
 *
 * @author Ricky
 * @date 2020-06-20 01:44:20
 */
public class Trie {

    private final TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
        root.isWord = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            if (node.children == null) {
                node.children = new TreeNode[26];
            }
            char ch = word.charAt(i);
            int idx = ch - 'a';
            TreeNode current = node.children[idx] != null
                ? node.children[idx]
                : new TreeNode(ch);
            current.isWord = current.isWord || i == word.length() - 1;
            node = node.children[idx] = current;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            if (node.children == null) {
                return false;
            }
            char ch = word.charAt(i);
            TreeNode match = node.children[ch - 'a'];
            if (match == null) {
                return false;
            }
            if (i == word.length() - 1 && !match.isWord) {
                return false;
            }

            node = match;
        }

        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for (int i = 0; i < prefix.length(); ++i) {
            if (node.children == null) {
                return false;
            }
            char ch = prefix.charAt(i);
            TreeNode match = node.children[ch - 'a'];
            if (match == null) {
                return false;
            }

            node = node.children[ch - 'a'];
        }

        return true;
    }

    public static class TreeNode {
        public char val;

        public TreeNode[] children;

        public boolean isWord;

        public TreeNode() {

        }

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("apple"));
        System.out.println(trie.startsWith("applea"));
//        input
//        ["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
//        [[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]

//        output
//        [null,null,null,null,null,null,null,false,true,false,false,false,false,false,true,true,false,true,true,false,false,false,true,true,true]
    }
}
