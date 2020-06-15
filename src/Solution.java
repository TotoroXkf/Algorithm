import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> currentList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.addLast(null);
                }
                List<Integer> level = new ArrayList<>(currentList);
                result.add(0, level);
                currentList = new ArrayList<>();
                continue;
            }
            currentList.add(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return result;
    }
}