### 将单向链表按某值划分成左边小、中间相等、右边大的形式
> 给定一个链表，再给定一个值，调整链表使成为左半部分小于指定值，右半部分大于指定值

**思路**

先便利一遍设置尾节点
然后遇到一个大于的数就放到链表的末尾即可

**代码**

```python
def adjust_link_list(head, pivot):
    """
    :type head:ListNode
    :type pivot:int
    :rtype :ListNode
    """
    if head.next is None:
        return head
    p_head = ListNode(-1)
    p_head.next = head
    node = p_head
    while node.next is not None:
        node = node.next
    tail = node
    border = node
    node = p_head
    while node.next is not border:
        if node.next.value > pivot:
            tail.next = node.next
            node.next = node.next.next
            tail.next.next = None
            tail = tail.next
        else:
            node = node.next
    if border.value > pivot:
        node.next = border.next
        tail.next = border
        border.next = None
    return p_head.next
```

