data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val nodes = mutableListOf<ListNode?>()
        var nextNode = head
        for (i in 1..k) {
            if (nextNode == null) {
                break
            }
            nodes.add(nextNode)
            nextNode = nextNode.next
        }

        if (nodes.size != k) {
            return head
        }

        nextNode = reverseKGroup(nextNode, k)

        for (i in nodes.indices) {
            nodes[i]!!.next = nextNode
            nextNode = nodes[i]
        }

        return nodes.last()
    }
}
