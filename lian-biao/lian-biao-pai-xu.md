# 链表排序

> 对链排序

**思路**

快排的思路，将链表划分为左边大右边小的情况，然后递归下去即可

下面的写法可以提升效率

创建一个头结点，然后这个头结点指向小于key的节点那个部分。 然后原本的head就指向大的那个部分 最后拼成一个链表即可 这样做可以避免反复头插来提升效率

**代码**

```kotlin
fun sortList(head: ListNode): ListNode {
    val dummy = ListNode(0)
    dummy.next = head
    helper(dummy, null)
    return dummy.next
}

private fun helper(before: ListNode, after: ListNode?) {
    if (before.next === after || before.next.next === after) return
    var p1 = before
    var head = before.next
    var p2 = before
    while (p2.next !== after) {
        if (p2.next.`val` >= head.`val`) {
            p2 = p2.next
        } else {
            p1.next = p2.next
            p1 = p1.next
            p2.next = p2.next.next
        }
    }
    p1.next = head
    p2.next = after

    helper(before, head)
    while (head.next != null && head.next.`val` === head.`val`) head = head.next
    helper(head, after)
}
```

