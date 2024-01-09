class Solution {
    fun intToRoman(num: Int): String {
        val thousandsDigit = num / 1000
        val hundredsDigit = (num - thousandsDigit * 1000) / 100
        val tensDigit = (num - thousandsDigit * 1000 - hundredsDigit * 100) / 10
        val unitsDigit = num - thousandsDigit * 1000 - hundredsDigit * 100 - tensDigit * 10
        return convertThousandsDigit(thousandsDigit) + convertHundredsDigit(hundredsDigit) +
                convertTensDigit(tensDigit) + convertUnitsDigit(unitsDigit)
    }


    private fun convertUnitsDigit(num: Int): String {
        return when (num) {
            0 -> ""
            1 -> "I"
            2 -> "II"
            3 -> "III"
            4 -> "IV"
            5 -> "V"
            6 -> "VI"
            7 -> "VII"
            8 -> "VIII"
            9 -> "IX"
            else -> ""
        }
    }

    private fun convertTensDigit(num: Int): String {
        return when (num) {
            0 -> ""
            1 -> "X"
            2 -> "XX"
            3 -> "XXX"
            4 -> "XL"
            5 -> "L"
            6 -> "LX"
            7 -> "LXX"
            8 -> "LXXX"
            9 -> "XC"
            else -> ""
        }
    }

    private fun convertHundredsDigit(num: Int): String {
        return when (num) {
            0 -> ""
            1 -> "C"
            2 -> "CC"
            3 -> "CCC"
            4 -> "CD"
            5 -> "D"
            6 -> "DC"
            7 -> "DCC"
            8 -> "DCCC"
            9 -> "CM"
            else -> ""
        }
    }

    private fun convertThousandsDigit(num: Int): String {
        return when (num) {
            0 -> ""
            1 -> "M"
            2 -> "MM"
            3 -> "MMM"
            else -> ""
        }
    }
}
