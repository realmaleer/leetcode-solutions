class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var k = 0
        var currentNum: Int? = null
        var currentIndex = 0
        for (i in nums) {
            if (i != currentNum) {
                nums[currentIndex] = i
                currentNum = i
                currentIndex++
                k++
            }
        }
        return k
    }
}
