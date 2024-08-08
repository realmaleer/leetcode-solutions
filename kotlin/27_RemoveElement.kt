class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var currentIndex = 0
        var k = 0
        for (i in nums) {
            if (i != `val`) {
                nums[currentIndex] = i
                currentIndex++
                k++
            }
        }

        return k
    }
}
