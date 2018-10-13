# N皇后问题
> 经典问题

**思路**
--------------------

基本思路就是递归判断每一行，能放下就放下，然后递归下一行，统计次数

斜着的判断标准是:如果当前位置是(a,b)并且(i,j)位置上有一个皇后并且如果  
`
|a-i|==|b-j|
`  
就说明(a,b)在(i,j)位置的斜线上

**代码**
--------------------

```python
def solve(n: int):
    if n < 1:
        return 0
    position = [-1 for i in range(n)]
    return put(position, 0, n)


def put(position: list, i: int, n: int):
    if i == n:
        return 1
    count = 0
    for j in range(n):
        if is_valid(position, i, j):
            position[i] = j
            count += put(position, i+1, n)
    return count


def is_valid(posiyion: list, i: int, j: int):
    for k in range(i):
        if posiyion[k] == j or abs(k-i) == abs(posiyion[k]-j):
            return False
    return True
```