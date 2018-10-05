class Solution:
    def removeElement(self, nums: list, val: int):
        i, left = 0, -1
        while i < len(nums):
            if nums[i] != val:
                nums[left+1], nums[i] = nums[i], nums[left+1]
                left += 1
            i += 1
        return left+1
