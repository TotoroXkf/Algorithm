class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        boolean leftResult = hasPathSum(root.left, sum);
        if (!leftResult) {
            return hasPathSum(root.right, sum);
        }
        return true;
    }
}