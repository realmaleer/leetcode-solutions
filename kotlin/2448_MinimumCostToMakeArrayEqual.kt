class Solution {
    fun minCost(nums: IntArray, cost: IntArray): Long {
        val numsInLong = nums.map { it.toLong() }
        val costInLong = cost.map { it.toLong() }
        val sortedIndex = List(numsInLong.size) { it }.sortedBy {
            nums[it]
        }

        var constant = 0.toLong()
        var coefficientOfX = 0.toLong()
        for (i in numsInLong.indices) {
            constant += numsInLong[i] * costInLong[i]
            coefficientOfX -= costInLong[i]
        }
        var lowestCost = constant + coefficientOfX * numsInLong[sortedIndex[0]]

        for (i in 1 until numsInLong.size) {
            constant -= numsInLong[sortedIndex[i - 1]] * costInLong[sortedIndex[i - 1]] * 2
            coefficientOfX += costInLong[sortedIndex[i - 1]] * 2
            val currentCost = constant + coefficientOfX * numsInLong[sortedIndex[i]]
            if (currentCost < lowestCost) {
                lowestCost = currentCost
            }
        }
        
        return lowestCost
    }
}
