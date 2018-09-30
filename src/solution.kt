import java.util.*

fun maximalRectangle(matrix: Array<CharArray>): Int {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return 0
    }
    val height = IntArray(matrix[0].size)
    var max = 0
    for (i in matrix.indices) {
        for (j in 0 until matrix[0].size) {
            if (matrix[i][j] == '1') {
                height[j] += 1
            } else {
                height[j] = 0
            }
        }
        max = Math.max(max, largestRectangleArea(height))
    }
    return max
}

fun largestRectangleArea(heights: IntArray): Int {
    var maxArea = 0
    val stack = LinkedList<Int>()
    for (i in 0 until heights.size + 1) {
        var height = 0
        if (i < heights.size) {
            height = heights[i]
        }
        while (!stack.isEmpty() && heights[stack.last()] > height) {
            val position = stack.removeLast()
            val area = if (stack.isEmpty()) {
                heights[position] * i
            } else {
                (i - stack.last() - 1) * heights[position]
            }
            if (area > maxArea) {
                maxArea = area
            }
        }
        stack.add(i)
    }
    return maxArea
}


fun main(args: Array<String>) {

}



