def get_max_len_common(str1: str, str2: str):
    if len(str1) == 0 or len(str2) == 0:
        return ""

    def get_dp():
        dp = [[0 for i in range(len(str2)+1)] for j in range(len(str1)+1)]
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])
                if str1[i-1] == str2[j-1]:
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + 1)
        return dp

    dp = get_dp()
    i, j = len(dp)-1, len(dp[0])-1
    res = ['' for i in range(dp[-1][-1])]
    index = len(res)-1
    while dp[i][j] != 0:
        if dp[i][j] == dp[i-1][j]:
            i -= 1
        elif dp[i][j] == dp[i][j - 1]:
            j -= 1
        else:
            res[index] = str1[i-1]
            index, i, j = index-1, i-1, j-1
    return "".join(res)


str1 = "1A2C3D4B56"
str2 = "B1D23CA45B6A"
print(get_max_len_common(str1, str2))
