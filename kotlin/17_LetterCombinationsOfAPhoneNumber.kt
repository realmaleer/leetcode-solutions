class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }

        val listOfCombinations = mutableListOf<String>()
        val possibleLetters = digits.map {
            convertDigitToLetter(it)
        }
        val letterPointer = MutableList(digits.length) { 0 }
        val numberOfPossibleFirstLetters = possibleLetters.first().length

        while (letterPointer.first() < numberOfPossibleFirstLetters) {
            val combination = possibleLetters.mapIndexed { i, s ->
                s[letterPointer[i]]
            }.joinToString("")
            listOfCombinations.add(combination)

            var currentPointer = digits.length - 1
            while (currentPointer >= 0) {
                if (
                    letterPointer[currentPointer] != possibleLetters[currentPointer].length - 1
                    || currentPointer == 0
                ) {
                    letterPointer[currentPointer]++
                    break
                } else {
                    letterPointer[currentPointer] = 0
                    currentPointer--
                }
            }
        }

        return listOfCombinations
    }

    private fun convertDigitToLetter(digit: Char): String {
        return when (digit) {
            '2' -> "abc"
            '3' -> "def"
            '4' -> "ghi"
            '5' -> "jkl"
            '6' -> "mno"
            '7' -> "pqrs"
            '8' -> "tuv"
            '9' -> "wxyz"
            else -> ""
        }
    }
}
