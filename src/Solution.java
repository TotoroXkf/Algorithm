import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Integer> currentList = new LinkedList<>();
        int level = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    level++;
                }
                result.add(currentList);
                currentList = new LinkedList<>();
                continue;
            }
            if (level % 2 == 0) {
                currentList.add(0, node.val);
            } else {
                currentList.add(node.val);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }
}