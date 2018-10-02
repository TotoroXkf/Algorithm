# fun isCross(str1: String, str2: String, target: String): Boolean {
#     if (target.length != str1.length + str2.length) {
#         return false
#     }
#     val row = if (str1.length > str2.length) str1 else str2
#     val col = if (str1.length > str2.length) str2 else str1
#     val dp = BooleanArray(col.length + 1)
#     dp[0] = true
#     for (i in 1..col.length) {
#         if (col[i - 1] == target[i - 1]) {
#             dp[i] = true
#         } else {
#             break
#         }
#     }
#     for (i in 1..row.length) {
#         dp[0] = dp[0] && (row[i - 1] == target[i - 1])
#         for (j in 1..col.length) {
#             dp[j] = (dp[j - 1] && col[j - 1] == target[i + j - 1]) || (dp[j] && row[i - 1] == target[i + j - 1])
#         }
#     }
#     return dp.last()
# }


def is_cross(str1: str, str2: str, target: str):
    if len(target) != len(str1+str2):
        return False
    row = str1
    col = str2
    if len(str1) <= len(str2):
        row = str2
        col = str1
    dp = [False for i in range(len(col)+1)]
    dp[0] = True
    for i in range(1, len(col)+1):
        if col[i-1] == target[i-1]:
            dp[i] = True
        else:
            break
    for i in range(1, len(row)+1):
        dp[0] = dp[0] and (row[i-1] == target[i-1])
        for j in range(1, len(col)+1):
            dp[j] = (dp[j - 1] and col[j - 1] == target[i + j - 1]
                     ) or (dp[j] and row[i - 1] == target[i + j - 1])
    return dp[-1]
