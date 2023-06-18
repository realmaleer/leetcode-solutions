class Solution {
    companion object {
        private const val MODULO = 1000000007
    }

    fun countPaths(grid: Array<IntArray>): Int {
        var pathNumberRecord: Array<IntArray> =
            Array(grid.size) { IntArray(grid.first().size) { -1 } }
        val sortedGrid = arrayListOf<Pair<Pair<Int, Int>, Int>>().apply {
            grid.mapIndexed { rowIndex, row ->
                row.mapIndexed { columnIndex, number ->
                    add(
                        Pair(
                            Pair(rowIndex, columnIndex),
                            number
                        )
                    )
                }
            }
        }.sortedBy {
            it.second
        }

        for (i in sortedGrid.indices) {
            val numberOfPath = getNumberOfPath(
                destination = sortedGrid[i].first,
                grid = grid,
                pathNumberRecord = pathNumberRecord
            )
            pathNumberRecord[sortedGrid[i].first.first][sortedGrid[i].first.second] = numberOfPath
        }

        var numberOfPath = 0

        for (i in pathNumberRecord.indices) {
            for (j in pathNumberRecord[i].indices) {
                numberOfPath = (numberOfPath + pathNumberRecord[i][j]).modulo()
            }
        }

        return numberOfPath
    }

    private fun getNumberOfPath(
        destination: Pair<Int, Int>,
        grid: Array<IntArray>,
        pathNumberRecord: Array<IntArray>
    ): Int {
        var numberOfPath = 1
        val upNumber = grid.getOrNull(destination.first - 1)?.getOrNull(destination.second)
        val downNumber = grid.getOrNull(destination.first + 1)?.getOrNull(destination.second)
        val leftNumber = grid.getOrNull(destination.first)?.getOrNull(destination.second - 1)
        val rightNumber = grid.getOrNull(destination.first)?.getOrNull(destination.second + 1)

        if (upNumber != null && upNumber < grid[destination.first][destination.second]) {
            pathNumberRecord[destination.first - 1][destination.second].let {
                numberOfPath = (numberOfPath + it).modulo()
            }
        }

        if (downNumber != null && downNumber < grid[destination.first][destination.second]) {
            pathNumberRecord[destination.first + 1][destination.second].let {
                numberOfPath = (numberOfPath + it).modulo()
            }
        }

        if (leftNumber != null && leftNumber < grid[destination.first][destination.second]) {
            pathNumberRecord[destination.first][destination.second - 1].let {
                numberOfPath = (numberOfPath + it).modulo()
            }
        }

        if (rightNumber != null && rightNumber < grid[destination.first][destination.second]) {
            pathNumberRecord[destination.first][destination.second + 1].let {
                numberOfPath = (numberOfPath + it).modulo()
            }
        }

        return numberOfPath
    }

    private fun Int.modulo(): Int {
        val quotient = this / MODULO
        return this - quotient * MODULO
    }
}
