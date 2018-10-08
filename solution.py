from base import *


def next_permutation(nums: list):
    size = len(nums)
    if size == 1:
        return
    i, j = size-2, size-1
    while i > -1 and nums[i] >= nums[j]:
        i, j = i-1, j-1
    if i != -1:
        j = size - 1
        while j > i+1 and nums[i] >= nums[j]:
            j -= 1
        nums[i], nums[j] = nums[j], nums[i]
    else:
        i = 0
    j = size-1
    while i < j:
        nums[i], nums[j] = nums[j], nums[i]
        i, j = i+1, j-1


test = [1, 2, 3, 4, 5]
for i in range(20):
    next_permutation(test)
    print(test)
