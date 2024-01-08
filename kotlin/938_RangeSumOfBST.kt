data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        var ans = 0

        if (root != null) {
            return if (root.`val` < low) {
                ans + rangeSumBST(root.right, low, high)
            } else if (root.`val` > high) {
                ans + rangeSumBST(root.left, low, high)
            } else {
                ans + root.`val` + rangeSumBST(root.left, low, high) + rangeSumBST(
                    root.right,
                    low,
                    high
                )
            }
        } else {
            return ans
        }
    }
}
