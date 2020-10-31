package com.leetcode.solution.problem381;

import java.util.*;

/**
 * O(1) 时间插入、删除和获取随机元素 - 允许重复
 *
 * @author Ricky
 * @date 2020-10-31 21:15:07
 */
public class RandomizedCollection {

    private Map<Integer, Set<Integer>> indexMap = new HashMap<>();

    private List<Integer> arrayList = new ArrayList<>();

    private Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> set;
        boolean res = (set = indexMap.get(val)) == null || set.isEmpty();
        indexMap.computeIfAbsent(val, k -> new HashSet<>())
            .add(arrayList.size());
        arrayList.add(val);
        return res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (arrayList.isEmpty()) {
            return false;
        }
        Set<Integer> valIndexSet;
        if ((valIndexSet = indexMap.get(val)) == null) {
            return false;
        }
        if (valIndexSet.isEmpty()) {
            return false;
        }
        int lastIndex = arrayList.size() - 1;
        int lastValue = arrayList.get(lastIndex);
        Iterator<Integer> valIndexSetIterator = valIndexSet.iterator();
        int valIndex = valIndexSetIterator.next();
        valIndexSetIterator.remove();
        arrayList.set(valIndex, lastValue);
        if (lastIndex != valIndex) {
            Set<Integer> lastValueSet = indexMap.get(lastValue);
            lastValueSet.remove(lastIndex);
            lastValueSet.add(valIndex);
        }
        arrayList.remove(lastIndex);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return arrayList.get(random.nextInt(arrayList.size()));
    }
}
