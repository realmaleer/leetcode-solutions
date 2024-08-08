data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        if (head.next == null) {
            return head
        }

        val remainingNodes = swapPairs(head.next!!.next)
        val secondNode = head.next
        head.next = remainingNodes
        if (secondNode != null) {
            secondNode.next = head
        }

        return secondNode
    }
}
