class Solution {
    private lateinit var maxSumRecord: MutableList<Int?>

    fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        val n = arr.size
        maxSumRecord = MutableList(n) { null }
        return handleNextPartition(arr.toList(), k, 0)
    }

    private fun handleNextPartition(
        arr: List<Int>,
        k: Int,
        startIndex: Int
    ): Int {
        val n = arr.size
        if (n <= k) {
            return maxSum(arr)
        }
        maxSumRecord[startIndex]?.let {
            return it
        }

        var max: Int? = null

        for (i in 1..k) {
            val firstPartition = arr.subList(0, i)
            val secondPartition = arr.subList(i, n)
            val sum = maxSum(firstPartition) + handleNextPartition(
                secondPartition,
                k,
                startIndex + i
            )

            if (sum >= (max ?: sum)) {
                max = sum
            }

            maxSumRecord[startIndex] = max
        }

        return max ?: 0
    }

    private fun maxSum(arr: List<Int>): Int {
        val n = arr.size
        return (arr.maxOrNull() ?: 0) * n
    }
}
