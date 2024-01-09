class Solution {
    fun maxArea(height: IntArray): Int {
        val sortedHeight = IntArray(height.size) { it }
            .sortedByDescending { height[it] }
        var leftLineOfMaxAmount = min(sortedHeight[0], sortedHeight[1])
        var rightLineOfMaxAmount = max(sortedHeight[0], sortedHeight[1])
        var checkedLeftLine = leftLineOfMaxAmount
        var checkedRightLine = rightLineOfMaxAmount
        var maximumAmount =
            (rightLineOfMaxAmount - leftLineOfMaxAmount) * min(
                height[sortedHeight[0]],
                height[sortedHeight[1]]
            )

        for (i in 2 until height.size) {
            val currentLine = sortedHeight[i]
            if (currentLine in (checkedLeftLine + 1) until checkedRightLine) {
                continue
            }

            if (currentLine < sortedHeight[0]) {
                var currentMaxLine = sortedHeight[0]
                for (j in 0 until i) {
                    if (sortedHeight[j] >= currentMaxLine) {
                        val currentAmount = (sortedHeight[j] - currentLine) * min(
                            height[currentLine],
                            height[sortedHeight[j]]
                        )

                        if (currentAmount >= maximumAmount) {
                            maximumAmount = currentAmount
                            currentMaxLine = sortedHeight[j]
                        }
                    }
                }

                checkedLeftLine = currentLine
            } else if (currentLine > sortedHeight[0]) {
                var currentMaxLine = sortedHeight[0]
                for (j in 0 until i) {
                    if (sortedHeight[j] <= currentMaxLine) {
                        val currentAmount = (currentLine - sortedHeight[j]) * min(
                            height[currentLine],
                            height[sortedHeight[j]]
                        )

                        if (currentAmount >= maximumAmount) {
                            maximumAmount = currentAmount
                            currentMaxLine = sortedHeight[j]
                        }
                    }
                }

                checkedRightLine = currentLine
            }
        }

        return maximumAmount
    }
}
