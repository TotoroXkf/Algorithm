class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode start, ListNode end) {
        if (start == end) {
            return null ;
        }
        ListNode node = start;
        int len = 0;
        while (node != end) {
            len++;
            node = node.next;
        }
        len /= 2;
        node = start;
        while (len > 0) {
            node = node.next;
            len--;
        }
        TreeNode root = new TreeNode(node.val);
        root.left = sortedListToBST(start, node);
        root.right = sortedListToBST(node.next, end);
        return root;
    }
}