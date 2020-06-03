import struct.ListNode;

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode left = preHead;
        ListNode preNode = head;
        ListNode node = preNode.next;
        for (int i = 1; i < m; i++) {
            left = preNode;
            preNode = node;
            node = node.next;
        }
        for (int i = m; i < n; i++) {
            ListNode temp = node.next;
            node.next = preNode;
            preNode = node;
            node = temp;
        }
        left.next.next = node;
        left.next = preNode;
        return preHead.next;
    }
}