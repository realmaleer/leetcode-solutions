class Solution {
    fun longestPalindrome(s: String): String {
        var longestString = ""

        for (i in s.indices) {
            for (j in s.indices) {
                if (i - j < 0 || i + j >= s.length) {
                    break
                }
                val subString = s.substring(
                    i - j,
                    i + j + 1
                )
                if (subString == subString.reversed()) {
                    if (longestString.length < subString.length) {
                        longestString = subString
                    }
                } else {
                    break
                }
            }
        }

        for (i in s.indices) {
            for (j in s.indices) {
                if (i - j < 0 || i + j + 1 >= s.length) {
                    break
                }
                val subString = s.substring(
                    i - j,
                    i + j + 2
                )
                if (subString == subString.reversed()) {
                    if (longestString.length < subString.length) {
                        longestString = subString
                    }
                } else {
                    break
                }
            }
        }

        return longestString
    }
}
