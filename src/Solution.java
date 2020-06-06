class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode[] preNode = new TreeNode[1];
        TreeNode[] result = new TreeNode[2];
        getNodes(root, result, preNode);
        int temp = result[0].val;
        result[0].val = result[1].val;
        result[1].val = temp;
    }

    public void getNodes(TreeNode root, TreeNode[] result, TreeNode[] preNode) {
        if (root == null) {
            return;
        }
        getNodes(root.left, result, preNode);
        if (preNode[0] != null && preNode[0].val > root.val) {
            if (result[0] == null) {
                result[0] = preNode[0];
            }
            result[1] = root;
        }
        preNode[0] = root;
        getNodes(root.right, result, preNode);
    }
}