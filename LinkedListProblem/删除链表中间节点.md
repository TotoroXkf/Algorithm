### 删除链表中间节点
> 如题

**思路**

快慢指针的应用。一个指针一次跑两个位置，一个指针一次跑一个位置，快指针跑出去的时候慢指针即在中间节点

由于是删除，所以让慢指针在hend的前面一个位置即可

**代码**

```python
def delete_mid_node(head):
    """
    :type head:ListNode
    :rtype :ListNode
    """
    if head is None:
        return None

    slow = ListNode(0)
    slow.next = head
    fast = head
    while fast is not None:
        fast = fast.next
        if fast is None:
            continue
        fast = fast.next
        if fast is None:
            continue

        slow = slow.next

    if slow.next is head:
        return head.next

    fast = slow.next
    slow.next = fast.next
    return head
```