def maximal_rectangle(matrix: list):
    rows = len(matrix)
    if rows == 0:
        return 0
    cols = len(matrix[0])
    if cols == 0:
        return 0
    height = [0 for _ in range(cols)]
    result = 0
    for i in range(rows):
        for j in range(cols):
            if matrix[i][j] == '1':
                height[j] += 1
            else:
                height[j] = 0
        result = max(result, largest_rectangle_area(height))
    return result


def largest_rectangle_area(heights: list):
    result = 0
    stack = []
    size = len(heights)
    for i in range(0, size + 1):
        height = 0
        if i < size:
            height = heights[i]
        while len(stack) > 0 and heights[stack[-1]] > height:
            position = stack.pop(-1)
            if len(stack) == 0:
                area = heights[position] * i
            else:
                area = (i - stack[-1] - 1) * heights[position]
            if area > result:
                result = area
        stack.append(i)
    return result
