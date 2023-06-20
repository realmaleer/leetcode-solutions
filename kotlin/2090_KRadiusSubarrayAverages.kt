class Solution {
    fun getAverages(nums: IntArray, k: Int): IntArray {
        val size = nums.size
        val totalNumber = 2 * k + 1
        val average = mutableListOf<Int>()
        var previousSum = 0.toLong()
        for (i in nums.indices) {
            if (i < k || i >= size - k) {
                average.add(-1)
            } else if (i == k) {
                previousSum = (nums.map { it.toLong() }.subList(0, totalNumber).sum())
                average.add((previousSum / totalNumber).toInt())
            } else {
                previousSum = previousSum - nums[i - k - 1] + nums[i + k]
                average.add((previousSum / totalNumber).toInt())
            }
        }
        return average.toIntArray()
    }
}
