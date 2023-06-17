class Solution {
    fun makeArrayIncreasing(arr1: IntArray, arr2: IntArray): Int {
        val sortedArr2 = arr2.sorted()
        var combinations = mutableListOf<Triple<Int, Int, Int>>() // first: number of operations; second: last element in the temporary list; third: next unused index of arr2
            .apply {
                if (sortedArr2.first() < arr1.first()) {
                    add(
                        Triple(
                            1,
                            sortedArr2.first(),
                            1
                        )
                    )
                }
                add(
                    Triple(
                        0,
                        arr1.first(),
                        0
                    )
                )
            }

        for (i in 1 until arr1.size) {
            val newCombinations = mutableListOf<Triple<Int, Int, Int>>().apply {
                combinations.forEach { combination ->
                    if (combination.second < arr1[i]) {
                        add(
                            Triple(
                                combination.first,
                                arr1[i],
                                combination.third
                            )
                        )
                    }
                    val replacingIndex = getNextReplacingIndexOfArr2(
                        previousNumber = combination.second,
                        startingIndex = combination.third,
                        arr2 = sortedArr2
                    )
                    replacingIndex?.let {
                        add(
                            Triple(
                                combination.first + 1,
                                sortedArr2[it],
                                it + 1
                            )
                        )
                    }
                }
            }
            if (newCombinations.isEmpty()) return -1
            combinations = handleListHasSameLastElement(newCombinations)
        }

        combinations.map {
            it.first
        }.minOrNull()?.let {
            return it
        }?: return -1
    }

    private fun getNextReplacingIndexOfArr2(
        previousNumber: Int,
        startingIndex: Int,
        arr2: List<Int>
    ): Int? {
        for (i in startingIndex until arr2.size) {
            if (previousNumber < arr2[i]) {
                return i
            }
        }
        return null
    }

    private fun handleListHasSameLastElement(combinations: List<Triple<Int, Int, Int>>): MutableList<Triple<Int, Int, Int>> {
        val groupedCombinations = combinations.groupBy {
            it.second
        }
        return groupedCombinations.map {
            val minimumNumberOfOperations = it.value.map { combination ->
                combination.first
            }.minOrNull()
            val maxNumberOfNextIndex = it.value.map { combination ->
                combination.third
            }.maxOrNull()?:it.value.first().third
            minimumNumberOfOperations?.let { numberOfOperation ->
                Triple(
                    numberOfOperation,
                    it.key,
                    maxNumberOfNextIndex
                )
            }
        }.filterNotNull().toMutableList()
    }

    // Included in Kotlin 1.4
    private fun <T : Comparable<T>> Iterable<T>.minOrNull(): T? {
        val iterator = iterator()
        if (!iterator.hasNext()) return null
        var min = iterator.next()
        while (iterator.hasNext()) {
            val e = iterator.next()
            if (min > e) min = e
        }
        return min
    }

    // Included in Kotlin 1.4
    private fun <T : Comparable<T>> Iterable<T>.maxOrNull(): T? {
        val iterator = iterator()
        if (!iterator.hasNext()) return null
        var max = iterator.next()
        while (iterator.hasNext()) {
            val e = iterator.next()
            if (max < e) max = e
        }
        return max
    }
}
