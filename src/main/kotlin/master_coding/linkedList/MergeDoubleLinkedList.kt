package master_coding.linkedList

class ListNode(val value: Int, var next: ListNode? = null, var prev: ListNode? = null, var child: ListNode? = null)

fun flatten(head: ListNode): ListNode {
    if (head == null)
        return head

    var currentNode = head
    while (currentNode != null) {
        if (currentNode.child == null) {
            currentNode = currentNode.next!!
        } else {
            var tail = currentNode.child
            while (tail?.next != null) {
                tail = tail.next
            }

            tail?.next = currentNode.next
            if (tail?.next != null) {
                tail.next!!.prev = tail
            }

            currentNode.next = currentNode.child
            currentNode.next?.prev = currentNode
            currentNode.child = null
        }
    }

    return head
}