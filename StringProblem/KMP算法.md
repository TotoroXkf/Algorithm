# KMP算法
>给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

**思路**
--------------------


经典字符串匹配算法KMP
首先假设有一个needle字符串

`
abcdefghi
`

`
abc = fgh
`

当i字符不匹配的时候直接比较 haystack的当前字符和d字符就可以了.因为i字符不匹配，说明abcdefgh都是匹配的.同时abc = fgh.所以i之前的3个字符直接就是等于haystack当前位置的前3个字符的.所以直接比较haystack的当前字符和d字符就可以了

现在问题就是，如何知道一个字符串的最长前缀和后缀呢？

就像abc和fgh这样的

这时可以构建一个数组记录每一个位置的最长前缀和后缀的匹配情况

和这个数组叫next

**next[i]表示当i个字符不匹配时，从0到i-1的最长前缀和后缀**

next[0]不存在，就是-1了

next[1]就是0

当1位置的字符不匹配，前面只有一个字符，所以next[1] = 0

| a   | a   | c   | a   | a   | a   | c   | a   | i   |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| -1  | 0   |     |

然后从1位置开始遍历
next[1] = 0

所以之前有0个匹配的前缀后缀

那么只能让a和0位置比较了
相等，说明从0到1有1个前缀相同

那么next[2] = 1
再往后，next[2] = 1
说明之前有1个前缀匹配

看这个情况

`
ax....ay
`

之前有1个匹配，那么就从1位置，也就是第二个字符开始比较匹配即可

也就是用ax比较ay

看看能不能比较出来两个长度
所以此时比较needle[i]和needle[next[i]]
c!=a

继续这个过程比较needle[i]和needle[next[i]]，直到匹配到0位置（为什么之后在说）
执行这个过程就可以

| a   | a   | c   | a   | a   | a   | c   | a   | i   |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| -1  | 0   | 1   | 0   | 1   | 2   | 2   | 3   | 4   |

现在来说为什么会是重复那个过程得到解

aac太短，看aacaaa这个子串
现在到到了aacaaa的位置

| a   | a   | c   | a   | a   | a   | c   | a   | i   |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| -1  | 0   | 1   | 0   | 1   | 2   |     |     |     |

next 此时 = 2

说明之前是有2个匹配的前后缀
那么让当前字符a和第3个比较

a!=c

此时c对应的next的值是1
这个是关键，说明c之前还有1个匹配前后缀

抽象一下
假设字符串

`
abcde
`

`
ab = de
`

`
a=d,b=e
`

之前的又有1个匹配前后缀

`
a =b
`

所以

`
a = e
`

那么e后面的一个字符完全可以和b在比较，可能构建出来ab = ex的情况
这就是为什么还要重复那个过程的原因，直到0

总结下来，构建next数组
- next[0]不存在，就是-1
- next[1]是0
- 重复比较，j=next[i],needle[i]和needle[next[j]]。得到next[i]

有了数组之后，匹配字符串，不匹配的时候移动到next指定的位置，反复比较，就可以了

**代码**
--------------------

```python
def str_str(haystack: str, needle: str):
    if len(haystack) == 0 and len(needle) == 0:
        return 0
    elif len(haystack) == 0:
        return -1
    elif len(needle) == 0:
        return 0

    next_position = [0 for _ in range(len(needle))]

    def create_next():
        x, y = 0, -1
        next_position[0] = -1
        while x < len(needle) - 1:
            if y == -1 or needle[x] == needle[y]:
                y += 1
                x += 1
                next_position[x] = y
            else:
                y = next_position[y]
        return next_position

    create_next()

    i, j = 0, 0
    while i < len(haystack) and j < len(needle):
        if j == -1 or haystack[i] == needle[j]:
            i += 1
            j += 1
        else:
            j = next_position[j]
    if j == len(needle):
        return i - len(needle)
    else:
        return -1
```

