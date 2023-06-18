class Solution {
    fun reverse(x: Int): Int {
        return if (x > 0) {
            x.toString().reversed().toIntOrNull() ?: 0
        } else {
            ((x * (-1)).toString().reversed().toIntOrNull() ?: 0) * (-1)
        }
    }
}
