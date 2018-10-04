def jump(nums: list):
    result, cur, next_position = 0, 0, 0
    for i in range(len(nums)):
        if i > cur:
            result += 1
            cur = next_position
        next_position = max(next_position, nums[i]+i)
    return result


test = [2, 3, 1, 1, 2]
print(jump(test))