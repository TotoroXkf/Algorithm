# 反转部分单向链表

> 如题

**思路**

就是按照正常思路做就可以

注意细节

**代码**

```python
def reserve_link_area(head, start, end):
    """
    :type head:ListNode
    :type start:int
    :type end:int
    :rtype :ListNode
    """
    v_head = ListNode(-1)
    v_head.next = head
    pre = v_head
    i = 0
    while pre is not None and i in range(0, start):
        pre = pre.next
        i += 1
    if pre is None or pre.next is None:
        return head
    r_tail = pre
    last = pre.next

    while last is not None and i in range(start, end):
        i += 1
        temp = last.next
        last.next = pre
        pre = last
        last = temp

    temp = v_head
    while temp.next is not r_tail:
        temp = temp.next

    r_tail.next = last
    temp.next = pre
    if start == 1:
        return pre
    return head
```

