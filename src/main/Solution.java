package main;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> preList = new ArrayList<>();
        preList.add(1);
        List<Integer> currentList = preList;
        int index = 1;
        while (rowIndex >= index) {
            currentList = new ArrayList<>();
            currentList.add(1);
            for (int i = 1; i < index; i++) {
                currentList.add(preList.get(i) + preList.get(i - 1));
            }
            currentList.add(1);
            preList = currentList;
            index++;
        }
        return currentList;
    }
}