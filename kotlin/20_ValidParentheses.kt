class Solution {
    fun isValid(s: String): Boolean {
        val brackets = mutableListOf<Char>()
        s.forEach {
            if (it == '(' || it == '{' || it == '[') {
                brackets.add(it)
            } else {
                val lastBracket = brackets.lastOrNull()
                if (
                    (it == ')' && lastBracket == '(')
                    || (it == '}' && lastBracket == '{')
                    || (it == ']' && lastBracket == '[')
                ) {
                    brackets.removeLast()
                } else {
                    return false
                }
            }
        }

        return brackets.isEmpty()
    }
}
