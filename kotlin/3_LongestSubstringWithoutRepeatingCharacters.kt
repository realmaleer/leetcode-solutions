class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var longestLength = 0
        var currentSubstring = ""

        for (i in s.indices) {
            val currentSubStringLength = currentSubstring.length
            val lastRepeatedCharacterIndex =
                List(currentSubStringLength) { it }.find { currentSubstring[it] == s[i] }
            if (lastRepeatedCharacterIndex != null) {
                currentSubstring = currentSubstring.substring(
                    lastRepeatedCharacterIndex + 1,
                    currentSubStringLength
                ) + s[i]
            } else {
                currentSubstring += s[i]
                currentSubstring.length.let {
                    if (longestLength < it) {
                        longestLength = it
                    }
                }
            }
        }

        return longestLength
    }
}
