class Solution {
    fun myAtoi(s: String): Int {
        val trimString = s.trim()
        val firstCharacter = trimString.firstOrNull() ?: return 0
        if (!firstCharacter.isDigit()) {
            if (firstCharacter == '-' || firstCharacter == '+') {
                if (trimString.getOrNull(1)?.isDigit() != true) return 0
            } else {
                return 0
            }
        }
        val firstNonDigit =
            List(trimString.length - 1) { it + 1 }.find { !trimString[it].isDigit() }
        val number = firstNonDigit?.let {
            trimString.substring(0, it)
        } ?: trimString
        number.toIntOrNull()?.let {
            return it
        }
        return if (number.first() == '-') {
            -2147483648
        } else {
            2147483647
        }
    }
}
