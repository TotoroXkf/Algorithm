### N皇后问题
> 经典问题

**思路**

基本思路就是递归判断每一行，能放下就放下，然后递归下一行，统计次数

斜着的判断标准是:如果当前位置是(a,b)并且(i,j)位置上有一个皇后

如果
`
|a-i|==|b-j|
`
就说明(a,b)在(i,j)位置的斜线上

**代码**

```kotlin
fun solve(n: Int): Int {
    if (n < 1) {
        return 0
    }
    val position = IntArray(n) { -1 }
    return put(position, 0, n)
}

fun put(position: IntArray, i: Int, n: Int): Int {
    if (i == n) {
        return 1
    }
    var sum = 0
    for (j in 0 until n) {
        if (isValid(position, i, j)) {
            if (isValid(position, i, j)) {
                position[i] = j
                sum += put(position, i + 1, n)
            }
        }
    }
    return sum
}

fun isValid(position: IntArray, i: Int, j: Int): Boolean {
    for (k in 0 until i) {
        if (position[k] == j || abs(k - i) == abs(position[k] - j)) {
            return false
        }
    }
    return true
}
```