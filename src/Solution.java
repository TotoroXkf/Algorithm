class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth > 0 && rightDepth > 0) {
            return 1 + Math.min(leftDepth, rightDepth);
        } else if (leftDepth > 0) {
            return 1 + leftDepth;
        } else if (rightDepth > 0) {
            return 1 + rightDepth;
        } else {
            return 1;
        }
    }
}