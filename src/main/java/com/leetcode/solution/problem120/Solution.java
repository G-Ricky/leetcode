package com.leetcode.solution.problem120;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 三角形最小路径和
 *
 * @author Ricky
 * @date 2020-06-26 22:27:24
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        int[] prevLayerCost = new int[triangle.size()];
        int[] layerCost = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); ++i) {
            List<Integer> layer = triangle.get(i);
            for (int j = 0; j < layer.size(); ++j) {
                int currentCost = layer.get(j);
                if (i != 0) {
                    if (j > 0 && j < i) {
                        layerCost[j] = currentCost + Math.min(prevLayerCost[j - 1], prevLayerCost[j]);
                    } else if (j > 0) {
                        layerCost[j] = currentCost + prevLayerCost[j - 1];
                    } else {
                        layerCost[j] = currentCost + prevLayerCost[j];
                    }
                } else {
                    layerCost[j] = currentCost;
                }

                if (i == triangle.size() - 1) {
                    min = Math.min(min, layerCost[j]);
                }
            }

            for (int j = 0; j < layer.size(); ++j) {
                prevLayerCost[j] = layerCost[j];
                layerCost[j] = 0;
            }
        }

        return min;
    }
}
