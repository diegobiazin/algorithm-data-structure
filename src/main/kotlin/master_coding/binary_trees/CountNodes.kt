package master_coding.binary_trees

import java.lang.Math.pow
import kotlin.math.ceil

fun main() {
    val tree = TreeNode(3)
    tree.insert(arrayOf(1,1,1,1,1,1,1,1,1,1,1, null, null, null))
    print(countNodes(tree))
}

fun countNodes(root: TreeNode): Int {
    if (root.value == null)
        return 0

    val height = getTreeHeight(root);

    if (height == 0) return 1

    val upperCount = pow(2.toDouble(), height.toDouble()) - 1

    var left = 0
    var right = upperCount

    while (left < right) {
        val idxToFind = ceil((left + right) / 2)

        if (nodeExists(idxToFind.toInt(), height, root)) {
            left = idxToFind.toInt()
        } else {
            right = idxToFind - 1
        }
    }

    return (upperCount + left + 1).toInt()
}

fun getTreeHeight(rootInput: TreeNode): Int {
    var root = rootInput
    var height = 0
    while (root.left != null) {
        height++
        root = root.left!!
    }

    return height
}

fun nodeExists(idxToFind: Int, height: Int, nodeInput: TreeNode): Boolean {
    var node:TreeNode? = nodeInput
    var left = 0
    var right = Math.pow(2.toDouble(), height.toDouble()) - 1
    var count = 0

    while (count < height) {
        val midOfNode = Math.ceil((left + right) / 2);

        if (idxToFind >= midOfNode) {
            node = node?.right
            left = midOfNode.toInt()
        } else {
            node = node?.left
            right = midOfNode - 1
        }

        count++
    }

    return node != null
}