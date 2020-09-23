import java.util.LinkedList;

class BSTIterator {
    LinkedList<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        fill(root);
    }

    private void fill(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode result = stack.pop();
        if (result.right != null) {
            fill(result.right);
        }
        return result.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}