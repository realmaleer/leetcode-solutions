class Solution {
    fun generateParenthesis(n: Int): List<String> {
        var brackets = mutableListOf(listOf(), listOf("()"))
        var currentNumberOfBracket = 1

        while (currentNumberOfBracket < n) {
            var combinations = addOneMoreBracket(brackets[currentNumberOfBracket])
            var i = 2
            while (i <= (currentNumberOfBracket + 1) / 2) {
                val newCombinations = combineBrackets(
                    list1 = brackets[i],
                    list2 = brackets[currentNumberOfBracket + 1 - i]
                )
                combinations = (combinations + newCombinations).distinct()
                i++
            }
            currentNumberOfBracket++
            brackets.add(combinations)
        }

        return brackets[n]
    }

    private fun addOneMoreBracket(original: List<String>): List<String> {
        val results = mutableListOf<String>()
        original.forEach {
            results.add("($it)")
            results.add("()$it")
            results.add("$it()")
        }
        return results.distinct()
    }

    private fun combineBrackets(list1: List<String>, list2: List<String>): List<String> {
        val results = mutableListOf<String>()

        for (i in list1.indices) {
            for (j in list2.indices) {
                results.add(list1[i] + list2[j])
                results.add(list2[j] + list1[i])
            }
        }

        return results.distinct()
    }
}
