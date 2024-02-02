class Solution {
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        var numberOfDigits = low.toString().length
        var firstDigit = low / (10.0.pow(numberOfDigits - 1)).toInt()
        val sequentialList = mutableListOf<Int>()

        while (true) {
            if (firstDigit + numberOfDigits - 1 > 9) {
                firstDigit = 1
                numberOfDigits++
            }

            val num = getNextSequentialNumber(firstDigit, numberOfDigits)
            if (num > high) {
                break
            }
            if (num >= low) {
                sequentialList.add(num)
            }
            firstDigit++
        }

        return sequentialList
    }

    private fun getNextSequentialNumber(
        firstDigit: Int,
        numberOfDigits: Int
    ): Int {
        var num = 0.0
        for (i in 1..numberOfDigits) {
            num += (firstDigit + i - 1) * 10.0.pow(numberOfDigits - i)
        }
        return num.toInt()
    }
}
