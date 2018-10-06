from base import *


def generateParenthesis(n: int):
    result = []
    if n == 0:
        return result
    grow(n, result, "(", 1, 0)
    return result


def grow(n: int, result: list, s: str, left: int, right: int):
    if left == n and right == left:
        result.append(s)
    if left < n:
        grow(n, result, s + "(", left + 1, right)
    if left > right:
        grow(n, result, s + ")", left, right + 1)
