import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import struct.TreeNode;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        HashSet<TreeNode> set = new HashSet<>();
        stack.push(root);
        set.add(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.peek();
            if (currentNode.left != null && !set.contains(currentNode.left)) {
                set.add(currentNode.left);
                stack.push(currentNode.left);
                continue;
            }
            currentNode = stack.pop();
            result.add(currentNode.val);
            if (currentNode.right != null && !set.contains(currentNode.right)) {
                set.add(currentNode.right);
                stack.push(currentNode.right);
            }
        }
        return result;
    }
}