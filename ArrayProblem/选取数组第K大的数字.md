# 选取数组第K大的数字
> 如题

**思路**

利用快速排序的思想，将数组划分为左右两边。分割位置记为key。右边的数字都比分割位置的值大，或者等于，左边的都小于。然后判断以下三种情况
1. end-key=K。说明key右侧有K-1个比它大的数字。那么正好，num[key]就是答案。返回
2. end-key<k。说明key右侧比它大的值不足K-1个，那么应该放弃右半段。因为放弃了右半段相当于放弃了end-key-1个比key大的数字，所以K减去相对应的值，递归左半段
3. end-key>k。说明比key大的数大于K个，直接放弃左半段，因为在右半段还是要找第K大的数字，这一点是不变的。


**代码**
```python
def find_kth_largest(nums: list, k: int, start=-1, end=-1):
    if start == -1 and end == -1:
        return find_kth_largest(nums, k, 0, len(nums))
    else:
        if start < end:
            key = select_key(start, end)
            key_value = nums[key]
            left = start
            right = end - 1
            while left < right:
                while nums[left] < key_value and left < right:
                    left += 1
                nums[key] = nums[left]
                key = left
                while nums[right] >= key_value and left < right:
                    right -= 1
                nums[key] = nums[right]
                key = right
            nums[key] = key_value
            if end - key == k:
                return key_value
            elif end - key > k:
                start = (key + 1)
            else:
                k -= (end - key)
                end = key
            return find_kth_largest(nums, k, start, end)


def select_key(start: int, end: int):
    return randint(start, end - 1)
```