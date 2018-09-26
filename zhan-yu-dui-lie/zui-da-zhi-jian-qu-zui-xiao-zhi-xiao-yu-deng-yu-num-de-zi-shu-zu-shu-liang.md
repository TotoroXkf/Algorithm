# 最大值减去最小值小于等于num的子数组数量

> 给定一个数组，求出所有的子数组中，最大值减去最小值小于等于target的情况数量的总和

**思路**

和**生成窗口最大值数组**的思路差不多

维护一个max\_queue队列和min\_queue，分别放置当前区间的最大最小值，和之后的有效值

比如\[3,2,5,8,4,7,6,9\] target = 4

其中max\_queue队列应该总是保持降序，因为遇到大的值就会向前替换。min\_queue反过来

遇到3 max\_queue = {0} min\_queue = {1} 并且队头代表了当前的最大最小值，相减，判断是不是小于target

如果小于，说明当前区间的所有子数组都符合，向后移动

现在就是符合的，向后移动，遇到5，更新队列 max = {2} min = {1,2} 队头相减依然成立，向后移动。就是实际情况来看，前3个数的所有子区间的确也都是符合的

在向后遇到8，更新队列 max = {3} min = {1,2,3} 队头相减，不再成立了

这个时候就是要缩短区间了。首先此时的区间是从0-3这一段区间

一点一点看。从0开始，3这个位置的元素和前面的3个元素无法兼容，那么0只能和最远到2的元素结合，也就是\(0,1\),\(0,1,2\),都是成立的，max和min队列保证了这一点。结果+2即可

观察可以发现，就是+上\( j-1-i \)

然后0的所有情况就都算进去了

然后，缩短区间，变为1-3

同时更新max和min，会发现，如果丢弃了0位置的元素，那么和两个的队头相比，都不相等，说明丢弃的只是中间元素而已，不用更新

反之，如果和队头元素有一样的，就要更新max 和 min 此时不用更新，那么情况和刚才完全一样

然后区间是1-3，队列未更新，所以，从1 到2的都成立，也就是\(1,2\)。 在移动，2-3，此时1位置的元素丢弃，min队列需要更新，所以，再判断是不是相减符合情况。

结果符合，继续j向后，跟新队列

一直到j跑完整个数组，此时i停在中间某个位置，此时很容易想到，从i到数组末尾的所有子数组都成立，所以要不断向前移动i，并且结果+上\( j-1-i \)

最终返回结果即可

**代码**

```python
def get_num(array, target):
    """
    :type target:int
    :type array:list
    :rtype :int
    """
    max_queue = []
    min_queue = []
    i = 0
    j = 0
    result = 0
    while j < len(array):
        update_queue(array, j, max_queue, min_queue)

        while array[max_queue[0]] - array[min_queue[0]] > target:
            result += (j - 1 - i)
            if max_queue[0] == i:
                max_queue.pop(0)
            if min_queue[0] == i:
                min_queue.pop(0)
            i = i + 1
        j += 1

    while i < j:
        result += (j - 1 - i)
        i = i + 1
    return result


def update_queue(array, index, max_queue, min_queue):
    """
    :type array:list
    :type index:int
    :type max_queue:list
    :type min_queue:list
    """
    while max_queue and array[index] >= array[max_queue[-1]]:
        max_queue.pop(-1)
    max_queue.append(index)

    while min_queue and array[index] <= array[min_queue[-1]]:
        min_queue.pop(-1)
    min_queue.append(index)
```

