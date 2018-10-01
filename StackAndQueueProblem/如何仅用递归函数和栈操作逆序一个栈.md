### 如何仅用递归函数和栈操作逆序一个栈

> 只使用递归和栈操作逆转一个栈

**思路**

递归讲究的是每一次的操作都是原来的子操作

如果要反转一个栈，那么栈底就会到栈顶，倒数第二回到正数第二

所以，先取出并且移除栈底，然后反转剩下的栈，再将取出的栈底压入即可形成递归

**代码**

```python
def reverse_stack(stack):
    """
    :type stack:list
    :rtype:list
    """
    if len(stack) == 0:
        return
    value = get_and_remove_last(stack)
    reverse_stack(stack)
    stack.append(value)
    return stack


def get_and_remove_last(stack):
    """
    :type stack:list
    :rtype: int
    """
    if len(stack) == 1:
        return stack.pop(0)
    else:
        value = stack.pop(-1)
        return_value = get_and_remove_last(stack)
        stack.append(value)
        return return_value
```


