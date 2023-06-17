class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
       var sortedArray = nums.mapIndexed() { index, it ->
           Pair(it, index)
       }.sortedBy { it.first }
        
        while(1 < sortedArray.size) {
            sortedArray = if (sortedArray.first().first + sortedArray.last().first > target) {
                sortedArray.dropLast(1)
            } else if (sortedArray.first().first + sortedArray.last().first < target) {
                sortedArray.drop(1)
            } else {
                return intArrayOf(
                    sortedArray.first().second,
                    sortedArray.last().second
                ).sortedArray()
            }
        }
        
        return intArrayOf()
    }
}
