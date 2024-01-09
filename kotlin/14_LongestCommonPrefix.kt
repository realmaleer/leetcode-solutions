class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var commonPrefix = ""
        val firstWord = strs[0]

        for (i in firstWord.indices) {
            val currentChar = firstWord[i]
            for (j in 1 until strs.size) {
                if (strs[j].length <= i) {
                    return commonPrefix
                }
                if (currentChar != strs[j][i]) {
                    return commonPrefix
                }
            }
            commonPrefix += currentChar
        }

        return commonPrefix
    }
}
