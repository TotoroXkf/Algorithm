### 打印两个有序链表中的公共部分
> 如题

**思路**

由于链表有序，所以直接遍历两个链表，谁小谁向前走，遇到一样的输出即可

**代码**

```python
def print_common_area(head1, head2):
    """
    :type head1:ListNode
    :type head2:ListNode
    """
    first = head1
    second = head2

    while first is not None and second is not None:
        if first.value < second.value:
            first = first.next
        elif first.value > second.value:
            second = second.next
        else:
            print(first.value)
            first = first.next
            second = second.next
```