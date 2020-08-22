import struct.TreeNode;

class Solution {
    /**
     * 相对来说比较直接。
     * 判断当前的节点是不是叶子节点
     * 不是叶子节点，将当前节点值*10，递归左右，累加起来返回
     * 是叶子节点，加上父节点传递下来的值返回
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int parentValue) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val + parentValue;
        }
        int leftResult = sumNumbers(root.left, (parentValue + root.val) * 10);
        int rightResult = sumNumbers(root.right, (parentValue + root.val) * 10);
        return leftResult + rightResult;
    }
}