package master_coding.binary_trees

import java.util.*

// Level Order Of Binary Tree (Medium)
fun main() {
    val tree = TreeNode(3)
    tree.insert(arrayOf(6, 1, 9, 2, null, 4, null, 5, null, null, null, null, 8, null, null, null))
    levelOrder(tree)
}

fun levelOrder(root: TreeNode): ArrayList<ArrayList<Int>> {
    if (root.value == null)
        return arrayListOf()

    val result = ArrayList<ArrayList<Int>>()
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)

    while (queue.size > 0) {
        val currentLevelValues = ArrayList<Int>()
        var length = queue.size
        var count = 0

        while (count < length) {
            val currentNode = queue.remove()

            currentLevelValues.add(currentNode.value!!)

            if (currentNode.left != null) {
                queue.add(currentNode.left)
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right)
            }

            count++
        }

        result.add(currentLevelValues)
    }

    return result
}