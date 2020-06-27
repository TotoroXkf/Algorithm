package main;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> preList = triangle.get(i - 1);
            List<Integer> currentList = triangle.get(i);
            minValue = Integer.MAX_VALUE;
            for (int j = 0; j < currentList.size(); j++) {
                int value = Integer.MAX_VALUE;
                if (j - 1 > 0) {
                    value = preList.get(j - 1);
                }
                if (j < preList.size()) {
                    value = Math.min(value, preList.get(j));
                }
                currentList.set(j, currentList.get(j) + value);
                minValue = Math.min(currentList.get(j), minValue);
            }
        }
        return minValue;
    }
}