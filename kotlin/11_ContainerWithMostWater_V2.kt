class Solution {
    fun maxArea(height: IntArray): Int {
        var currentLeftLine = 0
        var currentRightLine = height.size - 1
        var maximumAmount = 0

        while (currentRightLine > currentLeftLine) {
            val rightLineHeight = height[currentRightLine]
            val leftLineHeight = height[currentLeftLine]
            val currentAmount = abs(currentRightLine - currentLeftLine) * min(
                rightLineHeight,
                leftLineHeight
            )

            if (currentAmount > maximumAmount) {
                maximumAmount = currentAmount
            }

            if (rightLineHeight > leftLineHeight) {
                currentLeftLine++
            } else {
                currentRightLine--
            }
        }
        
        return maximumAmount
    }
}
