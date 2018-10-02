# 二叉树中所有距离为 K 的结点
> 给出二叉树和一个特定节点，在给出k表示距离，返回所有和这个节点相距为k的节点的值

**思路**

照着题目的意思写即可。先找到指定节点，然后从指定节点向下遍历k层。再然后向前返回的时候返回一个距离表示指定节点和当前节点的距离，再从当前节点向下遍历k-distance层即可  
递归结束也就都找完了  


**代码**

```python
def distance_k(root:TreeNode, target:TreeNode, k:int):
    res = []
    find_node(root, target, k, res)
    return res


def find_node(node:TreeNode, target:TreeNode, k:int, res:list):
    if node is None:
        return -1
    if node is target:
        search_node(node, None, 0, k, res)
        return 0
    else:
        distance = find_node(node.left, target, k, res)
        if distance != -1:
            search_node(node, node.left, distance + 1, k, res)
            return distance + 1
        distance = find_node(node.right, target, k, res)
        if distance != -1:
            search_node(node, node.right, distance + 1, k, res)
            return distance + 1
        return -1


def search_node(node:TreeNode, avoid:TreeNode, current:int, k:int, res:list):
    if node is avoid or node is None:
        return
    if current == k:
        res.append(node.val)
    else:
        search_node(node.left, avoid, current + 1, k, res)
        search_node(node.right, avoid, current + 1, k, res)
```
