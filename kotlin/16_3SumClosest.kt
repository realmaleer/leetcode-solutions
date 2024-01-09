class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var minimumDifference = nums[0] + nums[1] + nums[2] - target
        var result = nums[0] + nums[1] + nums[2]

        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    val currentSum = nums[i] + nums[j] + nums[k]
                    val currentDifferent = currentSum - target
                    if (abs(currentDifferent) < abs(minimumDifference)) {
                        minimumDifference = currentDifferent
                        result = currentSum
                    }
                }
            }
        }

        return result
    }
}
