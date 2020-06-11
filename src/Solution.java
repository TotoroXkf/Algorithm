class Solution {
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        return buildTree(inOrder, 0, inOrder.length, postOrder, 0, postOrder.length);
    }

    private TreeNode buildTree(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (inEnd - inStart == 0 || postEnd - postStart == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postEnd - 1]);
        if (inEnd - inStart == 1 || postEnd - postStart == 1) {
            return root;
        }
        int inIndex = inStart;
        int postIndex = postStart;
        while (inOrder[inIndex] != postOrder[postEnd - 1]) {
            inIndex++;
            postIndex++;
        }
        root.left = buildTree(inOrder, inStart, inIndex, postOrder, postStart, postIndex);
        root.right = buildTree(inOrder, inIndex + 1, inEnd, postOrder, postIndex, postEnd - 1);
        return root;
    }
}