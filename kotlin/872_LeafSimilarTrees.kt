data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val leaves1 = retrieveLeafValueSequence(root1)
        val leaves2 = retrieveLeafValueSequence(root2)
        if (leaves1.size != leaves2.size) return false
        for (i in leaves1.indices) {
            if (leaves1[i] != leaves2[i]) return false
        }
        return true
    }

    private fun retrieveLeafValueSequence(root: TreeNode?): List<Int> {
        if (root == null) return listOf()

        return if (root.left == null && root.right == null) {
            listOf(root.`val`)
        } else {
            retrieveLeafValueSequence(root.left) + retrieveLeafValueSequence(root.right)
        }
    }
}
