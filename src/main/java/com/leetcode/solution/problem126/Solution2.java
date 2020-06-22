package com.leetcode.solution.problem126;

import java.util.*;

/**
 * @author Ricky
 * @date 2020-06-07 17:37:15
 */
public class Solution2 {

    private Map<Pair, Integer> costMap = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<Integer, String> unvisited = new HashMap<>();
        int i = 0;
        boolean containsEndWord = false;
        for (String word : wordList) {
            unvisited.put(i++, word);
            if (word.equals(endWord)) {
                containsEndWord = true;
            }
        }
        if (!containsEndWord) {
            return Collections.emptyList();
        }
        Set<String> visited = new HashSet<>();
        String current = beginWord;
        List<Integer> currentVisiteds = new LinkedList<>();

        while (!unvisited.isEmpty()) {
            for (Map.Entry<Integer, String> entry : unvisited.entrySet()) {
                if (getCost(current, entry.getValue()) == 1) {
                    currentVisiteds.add(entry.getKey());
                }
            }

            for (Integer currentVisited : currentVisiteds) {
                visited.add(unvisited.remove(currentVisited));
            }

            if (!unvisited.isEmpty()) {

            }
            currentVisiteds.clear();
        }

        return null;
    }

    private int getCost(String src, String dst) {
        if (costMap.get(Pair.of(src, dst)) == -1) {
            return -1;
        }

        int differentCount = 0;
        for (int i = 0; i < src.length(); ++i) {
            if (src.charAt(i) != dst.charAt(i)) {
                if (differentCount >= 1) {
                    differentCount = -1;
                    break;
                }
                ++differentCount;
            }
        }

        costMap.put(Pair.of(src, dst), differentCount);
        costMap.put(Pair.of(dst, src), differentCount);
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
