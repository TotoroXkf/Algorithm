import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return generateTrees(array, 0, n);
    }

    private List<TreeNode> generateTrees(int[] array, int left, int right) {
        List<TreeNode> result = new ArrayList<>();
        if (right == left) {
            return null;
        }
        if (right - left == 1) {
            result.add(new TreeNode(array[left]));
            return result;
        }
        for (int i = left; i < right; i++) {
            List<TreeNode> leftResult = generateTrees(array, left, i);
            List<TreeNode> rightResult = generateTrees(array, i + 1, right);
            if (leftResult != null && rightResult != null) {
                for (TreeNode leftNode : leftResult) {
                    for (TreeNode rightNode : rightResult) {
                        TreeNode root = new TreeNode(array[i]);
                        root.left = leftNode;
                        root.right = rightNode;
                        result.add(root);
                    }
                }
            } else if (leftResult != null) {
                for (TreeNode leftNode : leftResult) {
                    TreeNode root = new TreeNode(array[i]);
                    root.left = leftNode;
                    result.add(root);
                }
            } else if (rightResult != null) {
                for (TreeNode rightNode : rightResult) {
                    TreeNode root = new TreeNode(array[i]);
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }
}