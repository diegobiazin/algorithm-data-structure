package master_coding.binary_trees

import java.util.*

fun main() {
    val tree = TreeNode(1)
    tree.insert(arrayOf(2, 3, 4, 5, null, 6, null, 7, null, null, null, null, 8, null, null, null))
    rightSideViewDFS(tree)
}

fun dfs(node: TreeNode, currentLevel: Int, result: Queue<Int>) {
    if (node.value == null)
        return

    if (currentLevel >= result.size) {
        result.add(node.value)
    }

    if (node.right != null) {
        dfs(node.right!!, currentLevel + 1, result);
    }

    if (node.left != null) {
        dfs(node.left!!, currentLevel + 1, result);
    }
}

fun rightSideViewDFS(root: TreeNode): Queue<Int> {
    val result: Queue<Int> = LinkedList()

    dfs(root, 0, result)
    return result
}
