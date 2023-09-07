public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode leftNode = head;
        ListNode rightNode = head.next;
        while (rightNode != null) {
            ListNode nextNode = rightNode.next;
            rightNode.next = leftNode;
            leftNode = rightNode;
            rightNode = nextNode;
        }
        head.next = null;
        return leftNode;
    }
}