import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new LinkedList<>();
        pathSum(root, sum, currentList, result);
        return result;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> currentList, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        currentList.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(currentList));
            currentList.remove(currentList.size() - 1);
            return;
        }
        pathSum(root.left, sum, currentList, result);
        pathSum(root.right, sum, currentList, result);
        currentList.remove(currentList.size() - 1);
    }
}