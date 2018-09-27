### 两个单链表表示两个数字求相加的结果
> 如题

**思路**

这道题的思路是先把给出的每一个节点相加
然后选出那个长链作为主链，遍历每一个节点，大于10就给之后的节点加一
如果到了末尾还是要加一，就新建一个节点，值为1

**代码**

```kotlin
class ListNode(var value: Int) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode? {
    var x: ListNode?
    var y: ListNode?
    x = l1
    y = l2
    while (x != null && y != null) {
        val value = x.value + y.value
        x.value = value
        y.value = value
        x = x.next
        y = y.next
    }
    if (x == null) {
        x = l2
        y = x
    } else {
        x = l1
        y = x
    }
    var n = 0
    while (x != null) {
        x.value += n
        if (x.value >= 10) {
            n = 1
            x.value -= 10
            if (x.next == null) {
                x.next = ListNode(1)
                break
            }
        } else {
            n = 0
        }
        x = x.next
    }
    return y
}
```

