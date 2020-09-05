class Solution {
    /**
     * 归并排序的链表实现
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode listNode1 = sortList(head);
        ListNode listNode2 = sortList(fast);
        ListNode newHead = null;
        ListNode currentNode = null;
        while (listNode1 != null || listNode2 != null) {
            ListNode resultNode;
            // 存在一个链表为空时直接可以结束merge
            if (listNode1 == null || listNode2 == null) {
                if (listNode1 == null) {
                    resultNode = listNode2;
                } else {
                    resultNode = listNode1;
                }
                if (newHead == null) {
                    newHead = resultNode;
                } else {
                    currentNode.next = resultNode;
                }
                break;
            }
            // 谁小取谁
            if (listNode1.val <= listNode2.val) {
                resultNode = listNode1;
                listNode1 = listNode1.next;
            } else {
                resultNode = listNode2;
                listNode2 = listNode2.next;
            }
            if (newHead == null) {
                newHead = resultNode;
                currentNode = resultNode;
                continue;
            }
            currentNode.next = resultNode;
            currentNode = currentNode.next;
        }
        return newHead;
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