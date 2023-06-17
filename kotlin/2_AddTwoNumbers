/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null || l2 == null) {
            return null
        }
        var firstNode: ListNode? = l1
        var secondNode: ListNode? = l2
        val sumDigits = arrayListOf<Int>().apply {
            while (firstNode != null || secondNode != null) {
                val firstDigit = firstNode?.`val` ?: 0
                val secondDigit = secondNode?.`val` ?: 0
                val sum = firstDigit + secondDigit
                if (sum > 9) {
                    add(sum - 10)
                    firstNode?.next?.let {
                        it.`val` = it.`val` + 1
                        firstNode = firstNode?.next
                    } ?: kotlin.run {
                        firstNode = ListNode(1)
                    }
                } else {
                    add(sum)
                    firstNode = firstNode?.next
                }

                secondNode = secondNode?.next
            }
        }

        return constructListNode(sumDigits)
    }

    private fun constructListNode(digits: ArrayList<Int>): ListNode {
        val reversedDigits = digits.reversed()
        var digitNode = ListNode(reversedDigits[0])
        for (i in 1 until digits.size) {
            val next = digitNode
            digitNode = ListNode(reversedDigits[i])
            digitNode.next = next
        }
        return digitNode
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
