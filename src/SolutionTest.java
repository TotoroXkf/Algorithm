import org.junit.Test;

import java.util.List;

import struct.ListNode;
import struct.TreeNode;

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
