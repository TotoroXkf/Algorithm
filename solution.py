def min_path_sum(matrix: list):
    more = max(len(matrix), len(matrix[0]))
    less = min(len(matrix), len(matrix[0]))
    row_more = more == len(matrix)
    dp = [0 for i in range(less)]
    dp[0] = matrix[0][0]
    for i in range(1, less):
        dp[i] = dp[i - 1] + (matrix[0][i] if row_more else matrix[i][0])
    for i in range(1, more):
        dp[0] += matrix[i][0] if row_more else matrix[0][i]
        for j in range(1, less):
            value = matrix[i][j] if row_more else matrix[j][i]
            dp[j] = min(dp[j - 1], dp[j]) + value
    return dp[-1]


test = [
    [1, 2, 3, 1],
    [1, 2, 2, 2],
    [2, 5, 7, 1]
]
print(min_path_sum(test))
result = [
    [1, 3, 6, 7],
    [2, 4, 6, 8],
    [3, 8, 13, 9]
]
