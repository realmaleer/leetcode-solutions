import kotlin.math.floor

class Solution {
    companion object {
        private const val MODULO = 1000000007
    }

    fun numOfWays(nums: IntArray): Int {
        var tree: Node? = null
        for (number in nums) {
            tree = insertNumberToBinarySearchTree(number, tree)
        }
        tree?.let {
            return (getCombinationInfo(it).numberOfCombinations - 1).toInt()
        } ?: return 0
    }

    private fun insertNumberToBinarySearchTree(
        number: Int,
        tree: Node?
    ): Node {
        if (tree == null) {
            return Node(
                number = number,
                leftChild = null,
                rightChild = null
            )
        }
        return if (number < tree.number) {
            Node(
                number = tree.number,
                leftChild = insertNumberToBinarySearchTree(number, tree.leftChild),
                rightChild = tree.rightChild
            )
        } else {
            Node(
                number = tree.number,
                leftChild = tree.leftChild,
                rightChild = insertNumberToBinarySearchTree(number, tree.rightChild)
            )
        }
    }

    private fun getCombinationInfo(node: Node): CombinationInfo {
        if (node.leftChild == null && node.rightChild != null) {
            val rightInfo = getCombinationInfo(node.rightChild)
            return CombinationInfo(
                numberOfCombinations = rightInfo.numberOfCombinations,
                numberOfNodes = rightInfo.numberOfNodes + 1
            )
        } else if (node.rightChild == null && node.leftChild != null) {
            val leftInfo = getCombinationInfo(node.leftChild)
            return CombinationInfo(
                numberOfCombinations = leftInfo.numberOfCombinations,
                numberOfNodes = leftInfo.numberOfNodes + 1
            )
        } else if (node.rightChild != null && node.leftChild != null) {
            val rightInfo = getCombinationInfo(node.rightChild)
            val leftInfo = getCombinationInfo(node.leftChild)
            val numerator =
                ((rightInfo.numberOfCombinations.modulo() * leftInfo.numberOfCombinations).modulo() * factorial(
                    rightInfo.numberOfNodes + 1,
                    rightInfo.numberOfNodes + leftInfo.numberOfNodes
                )).modulo()
            val denominator = factorial(1, leftInfo.numberOfNodes)
            val inverse = getInverseOfDenominator(denominator)
            val totalCombinations = (numerator * inverse).modulo()
            val totalNodes = leftInfo.numberOfNodes + rightInfo.numberOfNodes + 1
            return CombinationInfo(
                numberOfCombinations = totalCombinations,
                numberOfNodes = totalNodes
            )
        } else {
            return CombinationInfo(
                numberOfCombinations = 1,
                numberOfNodes = 1
            )
        }
    }

    private fun getInverseOfDenominator(number: Long): Long {
        var r0 = number
        var s0 = 1.toLong()
        var t0 = 0.toLong()
        var r1 = MODULO.toLong()
        var s1 = 0.toLong()
        var t1 = 1.toLong()
        while (r1 != 0.toLong()) {
            val quotient = r0 / r1
            val r2 = r0 - quotient * r1
            val s2 = s0 - quotient * s1
            val t2 = t0 - quotient * t1
            r0 = r1
            s0 = s1
            t0 = t1
            r1 = r2
            s1 = s2
            t1 = t2
        }
        return s0
    }

    private fun factorial(
        startingNumber: Long,
        endNumber: Long
    ): Long {
        var number = 1.toLong()
        for (i in startingNumber..endNumber) {
            number = (number * i).modulo()
        }
        return number
    }

    private fun Long.modulo(): Long {
        return this - floor(this / MODULO.toDouble()).toLong() * MODULO
    }
}

data class Node(
    val number: Int,
    val rightChild: Node?,
    val leftChild: Node?
)

data class CombinationInfo(
    val numberOfNodes: Long,
    val numberOfCombinations: Long
)
