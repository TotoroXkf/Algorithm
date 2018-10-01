# fun maxProduct(nums: IntArray): Int {
#     if (nums.size == 1) return nums[0]
#     var max = nums[0]
#     var min = nums[0]
#     var result = nums[0]
#     for (i in 1 until nums.size) {
#         val maxPre = max
#         max = Math.max(Math.max(maxPre * nums[i], nums[i]), min * nums[i])
#         min = Math.min(Math.min(min * nums[i], nums[i]), maxPre * nums[i])
#         result = Math.max(result, max)
#     }
#     return result
# }

def max_product(nums):
    """
    :type nums:list
    :rtype :int
    """
    if len(nums)==1:
        return nums[0]
    max_value = nums[0]
    min_value = nums[0]
    result = nums[0]
    for i in range(1,len(nums)):
        max_pre = max_value
        max_value = max(max(max_pre*nums[i],nums[i]),min_value*nums[i])
        min_value = min(min(min_value*nums[i],nums[i]),max_pre*nums[i])
        result = max(result,max_value)
    return result

nums = [2,-5,-2,-4,3]
print(max_product(nums))