def length_of_longest_sub_string(s: str):
    n, j, i, ans = len(s), 0, 0, 0
    position_map = {}
    while j < n:
        if position_map.__contains__(s[j]):
            i = max(position_map[s[j]], i)
        ans = max(ans, j - i + 1)
        position_map[s[j]] = j + 1
        j += 1
    return ans