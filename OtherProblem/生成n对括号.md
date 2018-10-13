# 生成n对括号
> 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合  
> 例如，给出 n = 3，生成结果为：  
[  
  "( ( ( ) ) )",  
  "( ( ) ( ) )",  
  "( ( ) ) ( )",  
  "( ) ( ( ) )",  
  "( ) ( ) ( )"  
]  

**思路**
--------------------

很典型的回朔算法  
假设我们一位一位的拼接括号。那么每一位只可能是两个情况  
要不就是 '(' ,要不就是 ')'  
- 当前位置可以添加 '(' 的条件是 left<n 只要左括号没有达到上限就可以添加
- 当前位置可以添加 ')' 的条件是 left>right 只要左括号数比右括号数多就可以添加右括号  
用递归可以很简单的解决这个问题.

**代码**
--------------------
```python
def generateParenthesis(n: int):
    result = []
    if n == 0:
        return result
    grow(n, result, "(", 1, 0)
    return result


def grow(n: int, result: list, s: str, left: int, right: int):
    if left == n and right == left:
        result.append(s)
    if left < n:
        grow(n, result, s + "(", left + 1, right)
    if left > right:
        grow(n, result, s + ")", left, right + 1)
```

