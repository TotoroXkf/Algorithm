class Solution {
    public void flatten(TreeNode root) {
        flattenInternal(root);
    }

    public TreeNode[] flattenInternal(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode[] result = new TreeNode[2];
        result[0] = root;
        TreeNode[] leftResult = flattenInternal(root.left);
        TreeNode[] rightResult = flattenInternal(root.right);
        if (leftResult == null && rightResult == null) {
            result[1] = root;
        } else if (leftResult == null) {
            root.right = rightResult[0];
            result[1] = rightResult[1];
        } else if (rightResult == null) {
            root.left = null;
            root.right = leftResult[0];
            result[1] = leftResult[1];
        } else {
            root.left = null;
            root.right = leftResult[0];
            leftResult[1].right = rightResult[0];
            result[1] = rightResult[1];
        }
        return result;
    }
}