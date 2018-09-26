# 用栈来求解汉诺塔问题

> 经典汉诺塔问题

**思路**

就是按照游戏规则一步一步走就可以

首先，左右两个栈，表示左右两边的情况。中间一定是空的

然后从left栈pop一个元素，向右移动，移动到最右边，判断能不能直接放上去 不能的话需要把right栈的顶元素移动到left栈，过程样

所以设计两个函数，移动最左边的到最右边，和移动最右边的到最左边

然后在调度函数中不断调用右移动函数即可

**代码**

```python
count = 0


def slove_hanno_tower(n):
    """
    :type n: int
    :rtype : int
    """
    left_stack = [value for value in range(n, 0, -1)]
    right_stack = []

    while len(left_stack) > 0:
        move_to_right(left_stack, right_stack)

    return count


def move_to_right(left_stack, right_stack):
    """
    :type left_stack:list
    :type right_stack:list
    """
    global count
    value = left_stack.pop(-1)

    print(str(value) + " move to mid")
    count = count + 1

    if len(right_stack) == 0 or value < right_stack[-1]:
        right_stack.append(value)
    else:
        while len(right_stack) > 0 and value > right_stack[-1]:
            move_to_left(left_stack, right_stack)
        right_stack.append(value)

    print(str(value) + " move to right")
    count = count + 1


def move_to_left(left_stack, right_stack):
    """
    :type left_stack:list
    :type right_stack:list
    """
    global count
    value = right_stack.pop(-1)

    print(str(value) + " move to mid")
    count = count + 1

    if len(left_stack) == 0 or value < left_stack[-1]:
        left_stack.append(value)
    else:
        while len(left_stack) > 0 and value > left_stack[-1]:
            move_to_right(left_stack, right_stack)
        left_stack.append(value)

    print(str(value) + " move to left")
    count = count + 1
```

