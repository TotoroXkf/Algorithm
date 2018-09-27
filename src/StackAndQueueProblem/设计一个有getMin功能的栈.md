### 设计一个有getMin功能的栈

> 设计一个有push，pop，和getMin的栈，且时间复杂度都是O(1)

**思路**

需要一个额外的栈来辅助实现

一个date栈，一个min栈

当调用push方法把当前值压入date栈，然后比较min栈的栈顶和压入的元素，得到目前的最小值，然后压入栈中

当pop的时候同时弹出两个栈的栈顶值。

这样就可以维护min栈成为最小值栈

getMin就是返回栈顶就可以

**代码**

```python
class MyStack:
    def __init__(self):
        self.date_stack = []
        self.min_stack = []

    def pop(self):
        """
        :rtype:int
        """
        old_value = self.date_stack.pop(-1)
        self.min_stack.pop(-1)
        return old_value

    def push(self, value):
        """
        :type value:int
        """
        self.date_stack.append(value)
        if len(self.min_stack) == 0:
            self.min_stack.append(value)
        else:
            self.min_stack.append(min(value, self.min_stack[-1]))

    def get_min_value(self):
        """
        :rtype:int
        """
        return self.min_stack[-1]

```


