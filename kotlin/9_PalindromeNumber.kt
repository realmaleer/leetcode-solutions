class Solution {
    fun isPalindrome(x: Int): Boolean {
        val convertedString = x.toString()
        return convertedString == convertedString.reversed()
    }
}
