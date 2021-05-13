package master_coding.binary_trees

import java.util.*

fun main() {
    val tree = TreeNode(1)
    tree.insert(arrayOf(2, 3, 4, 5, null, 6, null, 7, null, null, null, null, 8, null, null, null))
    rightSideViewBFS(tree)
}

//Binary tree right side view - BFS
fun rightSideViewBFS(root: TreeNode): ArrayList<Int> {
    if (root.value == null)
        return arrayListOf()

    val result = arrayListOf<Int>()
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)

    while (queue.size > 0) {
        var length = queue.size
        var count = 0
        var currentNode: TreeNode? = null

        while (count < length) {
            currentNode = queue.remove()

            if (currentNode.left != null) {
                queue.add(currentNode.left)
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right)
            }

            count++;
        }

        result.add(currentNode?.value!!)
    }

    return result
}