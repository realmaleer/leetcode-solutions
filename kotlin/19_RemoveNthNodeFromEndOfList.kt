data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var currentNode = head
        val convertedList = mutableListOf<Int>()
        var reducedNode: ListNode? = null

        while (currentNode != null) {
            convertedList.add(currentNode.`val`)
            currentNode = currentNode.next
        }

        convertedList.removeAt(convertedList.size - n)
        convertedList.reversed().forEach {
            val newNode = ListNode(it)
            newNode.next = reducedNode
            reducedNode = newNode
        }

        return reducedNode
    }
}
