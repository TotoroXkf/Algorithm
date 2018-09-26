# 用一个栈实现另一个栈的排序

> 实现栈的排序，从顶到底依次减少。可以使用一个辅助栈，但是不允许使用其它数据结构

**思路**

维护一个help栈，help栈保持从底到顶升序

从stack栈pop一个元素，然后比较help栈顶和弹出元素。如果弹出元素小或者相等那就正好合适，直接压入help栈

反之，将help栈的数据push进入stack，直到能找到合适的位置，压入这个元素

最后将help栈的全部元素反压会stack即可完成排序

**代码**

```python
def sort_stack(stack):
    """
    :type stack:list
    """
    help_stack = []
    while len(stack) > 0:
        value = stack.pop(-1)
        if len(help_stack) == 0:
            help_stack.append(value)
        else:
            while len(help_stack) > 0 and value > help_stack[-1]:
                stack.append(help_stack.pop(-1))
            help_stack.append(value)
    while len(help_stack) > 0:
        stack.append(help_stack.pop(-1))
```

