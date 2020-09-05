class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(head.val);
        preHead.next = head;
        ListNode last = preHead;
        while (last.next != null) {
            ListNode nextNode = last.next;
            ListNode preNode = preHead;
            ListNode node = preHead.next;
            while (nextNode.val >= node.val && nextNode != node) {
                node = node.next;
                preNode = preNode.next;
            }
            if (node == nextNode) {
                last = nextNode;
                continue;
            }
            last.next = nextNode.next;
            ListNode temp = preNode.next;
            preNode.next = nextNode;
            nextNode.next = temp;
        }
        return preHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}