class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val totalNumberOfElements = nums1.size + nums2.size
        var currentIndex1 = 0
        var currentIndex2 = 0
        val combinedList = mutableListOf<Int>()

        for (i in 0..totalNumberOfElements / 2) {
            if (currentIndex1 >= nums1.size) {
                combinedList.add(nums2[currentIndex2])
                currentIndex2 += 1
            } else if (currentIndex2 >= nums2.size) {
                combinedList.add(nums1[currentIndex1])
                currentIndex1 += 1
            } else if (nums1[currentIndex1] < nums2[currentIndex2]) {
                combinedList.add(nums1[currentIndex1])
                currentIndex1 += 1
            } else {
                combinedList.add(nums2[currentIndex2])
                currentIndex2 += 1
            }
        }

        return if (totalNumberOfElements % 2 == 0) {
            (combinedList[totalNumberOfElements / 2] + combinedList[totalNumberOfElements / 2 - 1]) / 2.toDouble()
        } else {
            combinedList.last().toDouble()
        }
    }
}
