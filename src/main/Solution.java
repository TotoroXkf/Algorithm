package main;

import struct.TreeNode;

public class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumInternal(root);
        return max;
    }

    private int maxPathSumInternal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = root.val;
        int leftResult = maxPathSumInternal(root.left);
        int rightResult = maxPathSumInternal(root.right);
        max = Math.max(leftResult + rightResult + root.val, max);
        result = Math.max(result, Math.max(result + leftResult, result + rightResult));
        max = Math.max(result, max);
        return result;
    }
}