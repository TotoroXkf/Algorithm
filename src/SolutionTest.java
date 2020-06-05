import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();
    private Case testCase = new Case();

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        solution.inorderTraversal(root);
    }
} 
