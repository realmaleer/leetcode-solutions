class Solution {
    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        nums.sort()
        val division: MutableList<IntArray> = mutableListOf()
        var pointerIndex = 0

        while (pointerIndex < nums.size) {
            val difference = nums[pointerIndex + 2] - nums[pointerIndex]
            if (difference > k) {
                return emptyArray()
            } else {
                division.add(
                    intArrayOf(
                        nums[pointerIndex],
                        nums[pointerIndex + 1],
                        nums[pointerIndex + 2]
                    )
                )
            }

            pointerIndex += 3
        }

        return division.toTypedArray()
    }
}
