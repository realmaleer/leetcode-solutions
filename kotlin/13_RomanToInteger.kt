class Solution {
    fun romanToInt(s: String): Int {
        var result = 0

        for (i in s.indices) {
            when (s[i]) {
                'M' -> result += 1000
                'D' -> result += 500
                'C' -> {
                    if (i < s.length - 1 && (s[i + 1] == 'D' || s[i + 1] == 'M')) {
                        result -= 100
                    } else {
                        result += 100
                    }
                }
                'L' -> result += 50
                'X' -> {
                    if (i < s.length - 1 && (s[i + 1] == 'L' || s[i + 1] == 'C')) {
                        result -= 10
                    } else {
                        result += 10
                    }
                }
                'V' -> result += 5
                'I' -> {
                    if (i < s.length - 1 && (s[i + 1] == 'V' || s[i + 1] == 'X')) {
                        result -= 1
                    } else {
                        result += 1
                    }
                }
            }
        }

        return result
    }
}
