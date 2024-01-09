class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var reducedList1 = list1
        var reducedList2 = list2
        val sortedList = mutableListOf<Int>()
        var sortedNode: ListNode? = null

        while (reducedList1 != null || reducedList2 != null) {
            if (reducedList1 == null) {
                sortedList.add(reducedList2!!.`val`)
                reducedList2 = reducedList2.next
            } else if (reducedList2 == null) {
                sortedList.add(reducedList1.`val`)
                reducedList1 = reducedList1.next
            } else if (reducedList1.`val` < reducedList2.`val`) {
                sortedList.add(reducedList1.`val`)
                reducedList1 = reducedList1.next
            } else {
                sortedList.add(reducedList2.`val`)
                reducedList2 = reducedList2.next
            }
        }

        sortedList.reversed().forEach {
            val newNode = ListNode(it)
            newNode.next = sortedNode
            sortedNode = newNode
        }

        return sortedNode
    }
}
