package main;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int row = 1;
        while (numRows >= row) {
            List<Integer> currentList = new ArrayList<>();
            currentList.add(1);
            for (int i = 1; i < row - 1; i++) {
                List<Integer> preList = result.get(row - 2);
                currentList.add(preList.get(i) + preList.get(i - 1));
            }
            if (row != 1) {
                currentList.add(1);
            }
            result.add(new ArrayList<>(currentList));
            row++;
        }
        return result;
    }
}