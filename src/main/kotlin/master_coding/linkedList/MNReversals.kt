package master_coding.linkedList

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
    reverseBetween(listNode, 2, 4)
}

//class ListNode(
//    val value: Int,
//    var next: ListNode? = null
//)

fun reverseBetween(head: ListNode, m: Int, n: Int): ListNode? {
    var currentPos = 1
    var currentNode: ListNode? = head
    var start: ListNode? = head

    while (currentPos < m) {
        start = currentNode
        currentNode = currentNode?.next
        currentPos++;
    }

    var newList: ListNode? = null
    var tail = currentNode;

    while (currentPos >= m && currentPos <= n) {
        val next = currentNode?.next
        currentNode?.next = newList
        newList = currentNode
        currentNode = next
        currentPos++
    }

    start?.next = newList
    tail?.next = currentNode

    return if (m > 1) {
        head
    } else {
        newList
    }
};