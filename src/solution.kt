import java.util.*

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



