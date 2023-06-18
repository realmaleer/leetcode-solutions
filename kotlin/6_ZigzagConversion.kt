class Solution {
    fun convert(s: String, numRows: Int): String {
        val zigzag = mutableListOf<List<Char?>>()
        var unconvertedString = s

        while (unconvertedString.isNotEmpty()) {
            if (unconvertedString.length <= numRows) {
                zigzag.add(unconvertedString.toList())
                break
            } else {
                zigzag.add(unconvertedString.substring(0, numRows).toList())
                unconvertedString = unconvertedString.drop(numRows)
            }

            if (unconvertedString.length <= numRows - 2) {
                zigzag.add(
                    (listOf(null) + unconvertedString.toList() + List(numRows - 1 - unconvertedString.length) { null }).reversed()
                )
                break
            } else if (numRows > 2) {
                zigzag.add(
                    listOf(null) + unconvertedString.substring(0, numRows - 2).toList()
                        .reversed() + listOf(null)
                )
                unconvertedString = unconvertedString.drop(numRows - 2)
            }
        }

        var convertedString = ""

        for (i in 0 until numRows) {
            for (j in 0 until zigzag.size) {
                zigzag[j].getOrNull(i)?.let {
                    convertedString += it
                }
            }
        }

        return convertedString
    }
}
