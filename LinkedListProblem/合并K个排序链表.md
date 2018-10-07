# 合并K个排序链表
> 如题

**思路**

这个题的精髓之处就在于归并排序的二分思想。

假设有m个链表，每个链表的平均长度为n。

首先我们分析暴力求解的复杂度  
暴力求解就是迭代的合并每一个链表。  
第一个和第二个链表合并需要2n的复杂度    
新的和第三个合并需要2n+n=3n的复杂度  
新的和第四个合并需要3n+n=4n的复杂度  
......  
新的和最后一个合并需要(m-1)*n+n=mn的复杂度   
总的复杂度等于他们全部加起来  
(2+3+4+....m)*n  
渐进等于 n * (m^2)

如果使用归并排序的思想，可以将所有的链表逐步划分，然后合并，就可以剩下来复杂度。

按照归并排序的划分方法，m个链表将会被划分为logm层。  
比如8个链表，第一层就是4个在左边，4个在右边  
第二层就是2个一组，分为4组    
第三层就是1个一组，一共8组  
这样来看每一层的合并复杂度都是m*n  

比如上面举例的最后一层，每1个一组，两两合并，一共合并4次，一次2n，一共8n。
然后在上一层，每两个一组，两两合并，一次4n，合并2次，一共8n....
logm层，每层都是m * n，那么最后的复杂度就是m * n * logm。这样就大大降低了复杂度

所以每次折半划分链表组，二路合并即可

**代码**

```python
def merge_k_lists(lists: list, start=-1, end=-1):
    if start == -1 and end == -1:
        return merge_k_lists(lists, 0, len(lists)-1)
    if start == end:
        return lists[start]
    if start < end:
        mid = (start+end)//2
        l1 = merge_k_lists(lists, start, mid)
        l2 = merge_k_lists(lists, mid+1, end)
        return merge_two_link_list(l1, l2)
    return None


def merge_two_link_list(l1: ListNode, l2: ListNode):
    if l1 is None:
        return l2
    if l2 is None:
        return l1
    if l1.val < l2.val:
        l1.next = merge_two_link_list(l1.next, l2)
        return l1
    else:
        l2.next = merge_two_link_list(l1, l2.next)
        return l2
```