### 找到无序数组中最小的k个数

> 如题

**思路**

利用快排的思路，选取基准，一次划分为2个区间。然后看区间的范围是和k的关系

左半区间是小于右半区间的，所以如果左半区间范围等于k,左半区间就是解
反之可以向下递归

**代码**

```python
import random


def select_kth_min_number(array:list, k:int, left=-1, right=-1):
    if left == -1 and right == -1:
        left = 0
        right = len(array) - 1

    if left <= right:
        index = random.randint(left, right)
        key_value = array[index]
        copy_array = array[:]
        i = left
        j = right
        while i < j:
            while i < j and copy_array[i] < key_value:
                i = i + 1
            copy_array[index] = copy_array[i]
            while j > i and copy_array[j] >= key_value:
                j = j - 1
            copy_array[i] = copy_array[j]
            index = j
        copy_array[index] = key_value
        numbers = index - left + 1
        if numbers == k:
            res = copy_array[left:index + 1]
        elif numbers < k:
            res = copy_array[left:index + 1]
            res.extend(select_kth_min_number(copy_array, k - numbers, left=index + 1, right=right))
        else:
            res = select_kth_min_number(copy_array, k, left=left, right=index - 1)
        return res
    else:
        return []
```

