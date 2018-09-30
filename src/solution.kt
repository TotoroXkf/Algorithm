fun longestPalindrome(s: String): String {
    if (s.isEmpty()) {
        return ""
    }
    var start = 0
    var end = 1
    var maxLength = Integer.MIN_VALUE
    val growPalindrome = { left: Int, right: Int ->
        var i = left
        var j = right
        while (i > -1 && j < s.length && s[i] == s[j]) {
            i--
            j++
        }
        val len = j - i - 1
        if (len > maxLength) {
            maxLength = len
            start = i + 1
            end = j
        }
    }
    for (i in 0 until s.length - 1) {
        growPalindrome(i - 1, i + 1)
        if (s[i] == s[i + 1]) {
            growPalindrome(i - 1, i + 2)
        }
    }
    return s.substring(start, end)
}


fun main(args: Array<String>) {
    println(longestPalindrome("aba"))
}



