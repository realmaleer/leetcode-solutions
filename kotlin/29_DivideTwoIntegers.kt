import kotlin.math.abs

class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        val isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)
        val unsignedDividend = abs(dividend).toUInt().toString()
        val unsignedDivisor: UInt = abs(divisor).toUInt()
        var quotientString = ""
        var calculatingDigits = unsignedDividend.first().toString().toUInt()
        var quotientAndRemainder: Pair<UInt, UInt>

        for (i in 0 until unsignedDividend.length) {
            quotientAndRemainder = getQuotientAndRemainder(calculatingDigits, unsignedDivisor)
            quotientString += quotientAndRemainder.first.toString()
            if (i != unsignedDividend.length - 1) {
                calculatingDigits =
                    (quotientAndRemainder.second.toString() + unsignedDividend[i + 1].toString()).toUInt()
            }
        }

        val unsignedQuotient = quotientString.toUInt()
        return if (isNegative) {
            if (unsignedQuotient > 2147483648u) {
                -2147483648
            } else {
                -unsignedQuotient.toInt()
            }
        } else {
            if (unsignedQuotient > 2147483647u) {
                2147483647
            } else {
                unsignedQuotient.toInt()
            }
        }
    }

    private fun getQuotientAndRemainder(dividend: UInt, divisor: UInt): Pair<UInt, UInt> {
        var quotient = 0u
        var currentDividend = dividend

        while (currentDividend >= divisor) {
            currentDividend -= divisor
            quotient++
        }

        return Pair(quotient, currentDividend)
    }
}
