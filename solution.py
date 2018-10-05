def rob(nums:list):
    size = len(nums)
    if size==0:
        return 0
    if size ==1:
        return nums[0]
    pre = nums[0]
    last = max(nums[0],nums[1])
    for i in range(2,size):
        temp = last
        last = max(last,nums[i]+pre)
        pre = temp
    return last

test = [2,7,9,3,1]
print(rob(test))