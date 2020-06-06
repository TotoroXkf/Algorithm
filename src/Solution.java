class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        boolean leftResult = isValidBST(root.left, min, root.val);
        if (leftResult) {
            return isValidBST(root.right, root.val, max);
        }
        return false;
    }
}