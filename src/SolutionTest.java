import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator iterator = new BSTIterator(root);
        assert iterator.next() == 3;
        assert iterator.next() == 7;
        assert iterator.hasNext();
        assert iterator.next() == 9;
        assert iterator.hasNext();
        assert iterator.next() == 15;
        assert iterator.hasNext();
        assert iterator.next() == 20;
        assert !iterator.hasNext();
    }
}