import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        List<Integer> currentList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                result.add(currentList);
                currentList = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.addLast(null);
                }
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