data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var numberList = lists.mapIndexedNotNull { index, listNode ->
            listNode?.let { Pair(it, index) }
        }.sortedBy { it.first.`val` }.toMutableList()
        val sortedList = mutableListOf<Int>()

        while (numberList.isNotEmpty()) {
            val firstOfList = numberList.first()
            sortedList.add(firstOfList.first.`val`)
            val newNode = Pair(firstOfList.first.next, firstOfList.second)
            numberList.removeFirst()

            if (newNode.first != null) {
                val insertionIndex = numberList.binarySearch {
                    it.first.`val` - newNode.first!!.`val`
                }

                if (insertionIndex >= 0) {
                    numberList.add(insertionIndex, newNode as Pair<ListNode, Int>)
                } else {
                    numberList.add(-(insertionIndex + 1), newNode as Pair<ListNode, Int>)
                }
            }
        }

        var sortedListNode: ListNode? = null

        for (num in sortedList.reversed()) {
            val newListNode = ListNode(num)
            newListNode.next = sortedListNode
            sortedListNode = newListNode
        }

        return sortedListNode
    }
}
