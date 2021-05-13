package master_coding.linkedList

import java.util.*

fun main() {
    val listNode = ListNode(
        1,
        ListNode(
            2,
            ListNode(
                3,
                ListNode(
                    4,
                    ListNode(5)
                )
            )
        )
    )
    basicAndReverse(listNode)
}

fun basicAndReverse(head: ListNode): ListNode? {
    var prev: ListNode? = null
    var current: ListNode? = head

    while (current != null) {
        val nextTemp = current.next;
        current.next = prev
        prev = current
        current = nextTemp
    }

    return prev
}