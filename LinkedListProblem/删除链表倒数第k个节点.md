# 删除链表倒数第k个节点
> 如题

**思路**

删除倒数第k个节点，相当于从末尾开始删除第k各节点，所以只要让一个指针跑到结尾的时候，和另外一个指针相距k个节点，那么那个指针所在的就是倒数k个的前驱

**代码**

```python
def delete_last_kth_node(k, head):
    """
    :type k:int
    :type head:ListNode
    :rtype : ListNode
    """
    if k <= 0:
        return head

    pre = head
    back = head
    i = k

    while i > 0 and back is not None:
        back = back.next
        i -= 1

    if back is None:
        return head.next

    while back.next is not None:
        pre = pre.next
        back = back.next

    back = pre.next
    pre.next = back.next
    return head
```