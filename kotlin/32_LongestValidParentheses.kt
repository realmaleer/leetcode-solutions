class Solution {
    fun longestValidParentheses(s: String): Int {
        val indexOfOpenParenthesis = mutableListOf<Int>()
        val record = mutableListOf<Any>()

        s.forEachIndexed { index, c ->
            if (c == '(') {
                indexOfOpenParenthesis.add(record.size)
                record.add('(')
            } else if (indexOfOpenParenthesis.isNotEmpty()) {
                record[indexOfOpenParenthesis.last()] = 2
                indexOfOpenParenthesis.removeLast()
            } else {
                record.add(')')
            }
        }

        var previousRecord: Any? = record.firstOrNull()
        var longestLength = if (previousRecord is Int) previousRecord else 0
        for (i in 1 until record.size) {
            val currentRecord = record[i]
            if (previousRecord is Int) {
                if (currentRecord is Int) {
                    previousRecord += currentRecord
                    if (previousRecord > longestLength) {
                        longestLength = previousRecord
                    }
                } else {
                    previousRecord = currentRecord
                }
            } else {
                previousRecord = currentRecord
                if (currentRecord is Int && currentRecord > longestLength) {
                    longestLength = currentRecord
                }
            }
        }

        return longestLength
    }
}
