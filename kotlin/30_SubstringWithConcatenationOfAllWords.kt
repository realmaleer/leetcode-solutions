class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val firstWord = words.first()
        val wordSize = firstWord.length
        val numberOfWords = words.size
        val permutationList: MutableList<Int> = mutableListOf()
        val previousFirstWords: MutableList<String?> = MutableList(wordSize) { null }

        for (i in 0..s.length - wordSize * numberOfWords) {
            val previousWord = previousFirstWords.firstOrNull()

            if (previousWord != null) {
                val currentLastWord = s.substring(
                    i + wordSize * (numberOfWords - 1),
                    i + wordSize * numberOfWords
                )
                previousFirstWords.removeFirst()
                if (currentLastWord == previousWord) {
                    permutationList.add(i)
                    previousFirstWords.add(
                        s.substring(i, i + wordSize)
                    )
                } else {
                    previousFirstWords.add(null)
                }
                continue
            }

            var targetWord = s.substring(i, i + wordSize)
            val currentFirstWord = targetWord
            var currentIndex = i
            val wordsNotUsed: MutableList<String> = words.toMutableList()

            while (currentIndex < i + numberOfWords * wordSize) {
                var hasWord = false
                for (j in wordsNotUsed.indices) {
                    if (wordsNotUsed[j] == targetWord) {
                        hasWord = true
                        wordsNotUsed.removeAt(j)
                        break
                    }
                }
                if (hasWord && currentIndex + wordSize < i + numberOfWords * wordSize) {
                    currentIndex += wordSize
                    targetWord = s.substring(currentIndex, currentIndex + wordSize)
                } else {
                    break
                }
            }

            previousFirstWords.removeFirst()
            if (wordsNotUsed.isEmpty()) {
                permutationList.add(i)
                previousFirstWords.add(currentFirstWord)
            } else {
                previousFirstWords.add(null)
            }
        }

        return permutationList
    }
}

Solution().findSubstring("barfoothefoobarman", arrayOf("foo","bar"))
