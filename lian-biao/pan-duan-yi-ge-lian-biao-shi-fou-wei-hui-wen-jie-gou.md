# 判断一个链表是否为回文结构

> 如题

**思路**

用栈保存左半部分的值 然后遍历右半部分，比较即可

**代码**

```python
def is_reserved(head):
    """
    :type head:ListNode
    :rtype :bool
    """
    stack = []
    node = head
    length = 0
    while node is not None:
        length += 1
        node = node.next
    node = head
    for i in range(0, int(length / 2)):
        stack.append(node.value)
        node = node.next
    if length % 2 != 0:
        node = node.next
    while node is not None:
        value = stack.pop(-1)
        if value != node.value:
            return False
        node = node.next
    return True
```

