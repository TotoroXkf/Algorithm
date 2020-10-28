import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> currentList = new LinkedList<>();
        dfs(0, currentList, n, k, result);
        return result;
    }

    private void dfs(int start, LinkedList<Integer> currentList, int n, int k, List<List<Integer>> result) {
        if (1 == k) {
            if (n > 0 && n < 10 && n > start) {
                List<Integer> newList = new LinkedList<>(currentList);
                newList.add(n);
                result.add(newList);
            }
            return;
        }
        for (int i = start + 1; i < 10; i++) {
            if (i >= n) {
                break;
            }
            currentList.add(i);
            dfs(i, currentList, n - i, k - 1, result);
            currentList.removeLast();
        }
    }
}