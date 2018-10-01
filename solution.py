# fun getLIL(array: IntArray): Int {
#     val set = HashSet<Int>()
#     var res = 0
#     for (i in 0 until array.size - 1) {
#         set.clear()
#         var max_value = Int.MIN_VALUE
#         var min_value = Int.MAX_VALUE
#         for (j in i until array.size) {
#             if (set.contains(array[j])) {
#                 break
#             }
#             max_value = Math.max_value(max_value, array[j])
#             min_value = Math.min_value(min_value, array[j])
#             set.add(array[j])
#             if (max_value - min_value == j - i) {
#                 res = Math.max_value(res, j - i + 1)
#             }
#         }
#     }
#     return res
# }


def get_lti(array: list):
    element_set = set()
    res = 0
    for i in range(0, len(array) - 1):
        element_set.clear()
        max_value = -2147483648
        min_value = 2147483647
        for j in range(1, len(array)):
            if element_set.__contains__(array[j]):
                break
            max_value = max(max_value, array[j])
            min_value = min(min_value, array[j])
            element_set.add(array[j])
            if max_value - min_value == j - i:
                res = max(res, j - i + 1)
    return res


test = [5, 5, 3, 2, 6, 4, 3]
print(get_lti(test))
