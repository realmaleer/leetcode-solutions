class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val triplets = mutableListOf<List<Int>>()
        val positiveNumbers = mutableListOf<Int>()
        val negativeNumbers = mutableListOf<Int>()
        var numberOfZeros = 0

        for (i in nums) {
            if (i > 0) {
                positiveNumbers.add(i)
            } else if (i < 0) {
                negativeNumbers.add(i)
            } else {
                numberOfZeros++
            }
        }

        val distinctPositiveNumbers = positiveNumbers.distinct().sorted()
        val distinctNegativeNumbers = negativeNumbers.distinct().sorted()

        if (numberOfZeros > 2) {
            triplets.add(listOf(0, 0, 0))
        }

        if (numberOfZeros > 0) {
            for (i in distinctPositiveNumbers) {
                if (distinctNegativeNumbers.contains(-i)) {
                    triplets.add(listOf(-i, 0, i))
                }
            }
        }

        val repeatedPositiveNumbers = mutableSetOf<Int>()
        val repeatedNegativeNumbers = mutableSetOf<Int>()

        val sortedPositiveNumbers = positiveNumbers.sorted()
        sortedPositiveNumbers.forEachIndexed { index, num ->
            if (sortedPositiveNumbers.getOrNull(index + 1) == num) {
                repeatedPositiveNumbers.add(num)
            }
        }
        val sortedNegativeNumbers = negativeNumbers.sorted()
        sortedNegativeNumbers.forEachIndexed { index, num ->
            if (sortedNegativeNumbers.getOrNull(index + 1) == num) {
                repeatedNegativeNumbers.add(num)
            }
        }

        repeatedPositiveNumbers.forEach {
            val targetNegativeNumber = -2 * it
            if (sortedNegativeNumbers.contains(targetNegativeNumber)) {
                triplets.add(listOf(targetNegativeNumber, it, it))
            }
        }

        repeatedNegativeNumbers.forEach {
            val targetPositiveNumber = -2 * it
            if (sortedPositiveNumbers.contains(targetPositiveNumber)) {
                triplets.add(listOf(it, it, targetPositiveNumber))
            }
        }

        for (i in distinctPositiveNumbers.indices) {
            for (j in i + 1 until distinctPositiveNumbers.size) {
                val targetNegativeNumber =
                    -(distinctPositiveNumbers[i] + distinctPositiveNumbers[j])
                if (sortedNegativeNumbers.contains(targetNegativeNumber)) {
                    triplets.add(
                        listOf(
                            targetNegativeNumber,
                            distinctPositiveNumbers[i],
                            distinctPositiveNumbers[j]
                        )
                    )
                }
            }
        }

        for (i in distinctNegativeNumbers.indices) {
            for (j in i + 1 until distinctNegativeNumbers.size) {
                val targetPositiveNumber =
                    -(distinctNegativeNumbers[i] + distinctNegativeNumbers[j])
                if (sortedPositiveNumbers.contains(targetPositiveNumber)) {
                    triplets.add(
                        listOf(
                            targetPositiveNumber,
                            distinctNegativeNumbers[i],
                            distinctNegativeNumbers[j]
                        )
                    )
                }
            }
        }

        return triplets
    }
}
