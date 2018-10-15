# 将链表向右移动k个位置
> 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。  

> 示例 1:     
输入: 1->2->3->4->5->NULL, k = 2.  
输出: 4->5->1->2->3->NULL.  
解释:   
向右旋转 1 步: 5->1->2->3->4->NULL.  
向右旋转 2 步: 4->5->1->2->3->NULL.  

>示例 2:    
输入: 0->1->2->NULL, k = 4.  
输出: 2->0->1->NULL.  
解释:  
向右旋转 1 步: 2->0->1->NULL.  
向右旋转 2 步: 1->2->0->NULL.  
向右旋转 3 步: 0->1->2->NULL.  
向右旋转 4 步: 2->0->1->NULL.  

**思路**
-------


比较看coding的一道题。  
先一次遍历求出长度来，然后记录下尾节点和需要旋转的节点，改变立链向实现向右移动的效果

**代码**
-------


```python
def rotate_right(self, head: ListNode, k: int):
	node, tail = head, head
	size = 0
	while node is not None:
		size += 1
		if node.next is None:
			tail = node
		node = node.next
	if size == 0 or size == 1:
		return head
	k %= size
	s_head = ListNode(0)
	s_head.next = head
	node = s_head
	for i in range(size - k):
		node = node.next
	tail.next = head
	head = node.next
	node.next = None
	return head
```
