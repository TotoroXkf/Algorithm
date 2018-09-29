fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val result = ArrayList<Int>()
    for (i in nums.indices) {
        val index = Math.abs(nums[i]) - 1
        nums[index] = Math.abs(nums[index]) * -1
    }
    for ((index, value) in nums.withIndex()) {
        if (value > 0) {
            result.add(index + 1)
        }
    }
    return result
}

fun main(args: Array<String>) {
    println("xxx")
}



