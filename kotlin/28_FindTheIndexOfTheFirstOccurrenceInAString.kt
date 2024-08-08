class Solution {
    fun strStr(haystack: String, needle: String): Int {
        val lengthOfNeedle = needle.length
        for (i in 0..haystack.length - lengthOfNeedle) {
            if (haystack.substring(i, i + lengthOfNeedle) == needle) {
                return i
            }
        }
        return -1
    }
}
