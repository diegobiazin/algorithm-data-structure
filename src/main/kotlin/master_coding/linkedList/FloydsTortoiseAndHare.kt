package master_coding.linkedList

//class ListNode(val value: Int, val next: ListNode)

fun main() {
    ListNode(
        1,
        ListNode(
            2,
            ListNode(
                3
            )
        )
    )
    val input = ListNode(
        1,
        ListNode(
            2,
            ListNode(
                3,
                ListNode(
                    4,
                    ListNode(
                        5,
                        ListNode(
                            6,
                            ListNode(
                                7,
                                ListNode(
                                    8,
                                    ListNode(3)
                                )
                            )
                        )
                    )
                )
            )
        )
    )
    floydsTortoiseAndHare(input)
}

fun floydsTortoiseAndHare(head: ListNode?): ListNode? {
    if (head == null)
        return null

    var tortoise: ListNode? = head
    var hare: ListNode? = head

    while (true) {
        tortoise = tortoise?.next
        hare = hare?.next

        if (hare === null || hare.next === null) {
            return null
        } else {
            hare = hare.next
        }

        if (tortoise === hare)
            break
    }

    var p1: ListNode? = head
    var p2: ListNode? = tortoise

    while (p1 !== p2) {
        p1 = p1?.next
        p2 = p2?.next
    }

    print(p2)
    return p2
}

fun findCycle(head: ListNode?): ListNode? {
    var currentNode: ListNode? = head
    val seenNode = mutableSetOf<ListNode>()
    while (seenNode.contains(currentNode) != null) {
        if (currentNode?.next == null) {
            return null
        }
        seenNode.add(currentNode)
        currentNode = currentNode.next
    }
    return currentNode
}