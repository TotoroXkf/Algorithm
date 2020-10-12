class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(val);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode node = pre.next;
        while (node != null) {
            if (node.val == val) {
                pre.next = node.next;
                node = pre.next;
                continue;
            }
            pre = pre.next;
            node = node.next;
        }
        return preHead.next;
    }
}