import struct.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode node = head;
        while (node != null) {
            ListNode temp = node.next;
            node.next = preNode;
            preNode = node;
            node = temp;
        }
        return preNode;
    }
}