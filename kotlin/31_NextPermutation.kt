class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        if (nums.size == 1) {
            return
        }
        var currentIndex = nums.size - 2
        var noNextPermutation = false
        while (currentIndex >= 0) {
            if (nums[currentIndex] >= nums[currentIndex + 1]) {
                currentIndex--
            } else {
                break
            }
            if (currentIndex == -1) {
                noNextPermutation = true
            }
        }

        if (noNextPermutation) {
            val numberOfPairs = nums.size / 2
            var tempNum: Int

            for (i in 1..numberOfPairs) {
                tempNum = nums[i - 1]
                nums[i - 1] = nums[nums.size - i]
                nums[nums.size - i] = tempNum
            }
        } else {
            val leadingNum = nums[currentIndex]
            var leadingReplaceIndex: Int? = null

            for (i in currentIndex + 1 until nums.size) {
                if (nums[i] > leadingNum && (leadingReplaceIndex == null
                            || nums[i] <= nums[leadingReplaceIndex])
                ) {
                    leadingReplaceIndex = i
                }
            }

            leadingReplaceIndex?.let {
                nums[currentIndex] = nums[it]
                nums[it] = leadingNum
            }

            val numberOfPairs = (nums.size - currentIndex - 1) / 2
            var tempNum: Int

            for (i in 1..numberOfPairs) {
                tempNum = nums[currentIndex + i]
                nums[currentIndex + i] = nums[nums.size - i]
                nums[nums.size - i] = tempNum
            }
        }
    }
}
