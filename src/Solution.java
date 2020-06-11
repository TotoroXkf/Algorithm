class Solution {
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return buildTree(preOrder, 0, preOrder.length, inOrder, 0, inOrder.length);
    }

    private TreeNode buildTree(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (preRight - preLeft == 0 || inRight - inLeft == 0) {
            return null;
        }
        if (preRight - preLeft == 1 || inRight - inLeft == 1) {
            return new TreeNode(preOrder[preLeft]);
        }
        int preIndex = preLeft;
        int inIndex = inLeft;
        while (inOrder[inIndex] != preOrder[preLeft]) {
            inIndex++;
            preIndex++;
        }
        TreeNode root = new TreeNode(preOrder[preLeft]);
        TreeNode leftNode = buildTree(preOrder, preLeft + 1, preIndex + 1, inOrder, inLeft, inIndex);
        TreeNode rightNode = buildTree(preOrder, preIndex + 1, preRight, inOrder, inIndex + 1, inRight);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}