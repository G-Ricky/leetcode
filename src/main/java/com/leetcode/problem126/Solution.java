package com.leetcode.problem126;

import java.util.*;

/**
 * 单词接龙 II
 *
 * @author Ricky
 * @date 2020-06-07 13:58:12
 */
public class Solution {

    private final Map<Pair, Integer> costMap = new HashMap<>();

    private final Map<Pair, String> wordMap = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return Collections.emptyList();
        }

        List<String> randomAccess = wordList instanceof RandomAccess
            ? wordList
            : new ArrayList<>(wordList);

        // 初始化
        for (int i = 0; i < randomAccess.size(); ++i) {
            for (int j = i + 1; j < randomAccess.size(); ++j) {
                String src = wordList.get(i);
                String dst = wordList.get(j);
                Integer cost = findCost(src, dst);
                if (cost != null) {

                    costMap.put(Pair.of(src, dst), cost);
                    costMap.put(Pair.of(dst, src), cost);
                }
            }
        }

        for (int i = 0; i < randomAccess.size(); ++i) {
            for (int j = 0; j < randomAccess.size(); ++j) {
                for (int k = 0; k < randomAccess.size(); ++k) {
                    String wordi = wordList.get(i);
                    String wordj = wordList.get(j);
                    String wordk = wordList.get(k);
                    Integer cost1 = costMap.get(Pair.of(wordi, wordk));
                    Integer cost2 = costMap.get(Pair.of(wordk, wordj));
                    Integer cost3 = costMap.get(Pair.of(wordi, wordj));
                    if (cost1 != null && cost2 != null) {
                        if (cost3 == null || cost1 + cost2 < cost3) {
                            Pair pair = Pair.of(wordi, wordj);
                            costMap.put(pair, cost1 + cost2);
                            wordMap.put(pair, wordk);
                        }
                    }
                }
            }
        }

        if (costMap.get(Pair.of(beginWord, endWord)) == null) {
            return Collections.emptyList();
        }

        return null; //
    }

    private Integer findCost(String src, String dst) {
        int differentCount = 0;
        for (int i = 0; i < src.length(); ++i) {
            if (src.charAt(i) != dst.charAt(i)) {
                if (differentCount >= 1) {
                    return null;
                }
                ++differentCount;
            }
        }

        return differentCount;
    }

    public static class Pair {

        private String left;

        private String right;

        public Pair() {
        }

        public Pair(String left, String right) {
            this.left = left;
            this.right = right;
        }

        public String getLeft() {
            return left;
        }

        public Pair setLeft(String left) {
            this.left = left;
            return this;
        }

        public String getRight() {
            return right;
        }

        public Pair setRight(String right) {
            this.right = right;
            return this;
        }

        public static Pair of(String left, String right) {
            return new Pair(left, right);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(left, pair.left) &&
                Objects.equals(right, pair.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }
}
