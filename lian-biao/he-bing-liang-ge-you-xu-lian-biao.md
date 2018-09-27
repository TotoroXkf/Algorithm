### 合并两个有序链表
> 如题

**思路**

这个题用递归能很好的解决

对比两个节点，小的那个的next和另外那个大的节点看作为新链表的表头节点传递下去递归就可以了

**代码**

```kotlin
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1
    return if (l1.value < l2.value) {
        l1.next = mergeTwoLists(l1.next, l2)
        l1
    } else {
        l2.next = mergeTwoLists(l1, l2.next)
        l2
    }
}
```