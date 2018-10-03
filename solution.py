# fun longestConsecutive(num: IntArray): Int {
#     if (num.isEmpty()) {
#         return 0
#     }
#     val hashMap = HashMap<Int, Int>()
#     var result = 1
#     val merge = { low: Int, high: Int ->
#         val left = low - hashMap[low]!! + 1
#         val right = high + hashMap[high]!! - 1
#         val len = right - left + 1
#         hashMap[left] = len
#         hashMap[right] = len
#         result = max(result, len)
#     }
#     for (value in num) {
#         if (!hashMap.containsKey(value)) {
#             hashMap[value] = 1
#             if (hashMap.containsKey(value - 1)) {
#                 merge(value - 1, value)
#             }
#             if (hashMap.containsKey(value + 1)) {
#                 merge(value, value + 1)
#             }
#         }
#     }
#     return result
# }


def longest_consecutive(nums: list):
    if len(nums) == 0:
        return 0
    len_map = {}
    result = 1

    def merge(low: int, high: int):
        left = low - len_map[low] + 1
        right = high + len_map[high] - 1
        length = right - left + 1
        len_map[left] = length
        len_map[right] = length
        return max(result, length)

    for value in nums:
        if not len_map.__contains__(value):
            len_map[value] = 1
            if len_map.__contains__(value - 1):
                result = merge(value - 1, value)
            if len_map.__contains__(value + 1):
                result = merge(value, value + 1)
    return result


arr = [100,4,200,1,3,2]
print(longest_consecutive(arr))
