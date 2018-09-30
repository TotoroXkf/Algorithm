fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var maxArea = 0
    while (left < right) {
        val area = (right - left) * Math.min(height[left], height[right])
        if (area > maxArea) {
            maxArea = area
        }
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }
    return maxArea
}

fun main(args: Array<String>) {
    
}



