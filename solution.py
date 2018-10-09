from base import *


def longest_valid_parentheses(s: str):
    stack = []
    result, left, size = 0, -1, len(s)
    for i in range(size):
        if s[i] == '(':
            stack.append(i)
        elif stack:
            stack.pop(-1)
            result = max(
                result, i-left) if not stack else max(result, i-stack[-1])
        else:
            left = i
    return result
