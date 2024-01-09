class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val listOfQuadruplets = mutableListOf<List<Int>>()
        val sortedNums = reduceNums(nums.sorted())

        for (i in sortedNums.indices) {
            for (j in i + 1 until sortedNums.size) {
                for (k in j + 1 until sortedNums.size) {
                    for (m in k + 1 until sortedNums.size) {
                        val currentSum =
                            sortedNums[i] + sortedNums[j] + sortedNums[k] + sortedNums[m]
                        if (currentSum == target.toLong()) {
                            listOfQuadruplets.add(
                                listOf(
                                    sortedNums[i].toInt(),
                                    sortedNums[j].toInt(),
                                    sortedNums[k].toInt(),
                                    sortedNums[m].toInt()
                                )
                            )
                        }
                    }
                }
            }
        }

        return listOfQuadruplets.distinct()
    }

    private fun reduceNums(nums: List<Int>): List<Long> {
        var numberOfOccurrence = 0
        var currentNum = nums[0]
        val reducedNums = mutableListOf<Long>()

        nums.forEach {
            if (it != currentNum) {
                currentNum = it
                numberOfOccurrence = 0
                reducedNums.add(it.toLong())
            } else {
                if (numberOfOccurrence < 4) {
                    reducedNums.add(it.toLong())
                }
                numberOfOccurrence++
            }
        }

        return reducedNums
    }
}
