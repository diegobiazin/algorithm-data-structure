package master_coding.binary_trees

import java.util.*

fun main() {
    val root = TreeNode()
//    root.insert(arrayOf(1, 1, 1, 1, null, null, null, 1, null, null, null, 1, null, null));
//    root.insert(arrayOf(9, 4, 6, 20, 170, 15, 1, 170));
    root.insert2(9)
    root.insert2(4)
    root.insert2(6)
    root.insert2(20)
    root.insert2(170)
    root.insert2(15)
    root.insert2(1)
    traverse(root)
}

fun maxDepth(node: TreeNode, currentDepthInput: Int): Int {
    var currentDepth = currentDepthInput
    if (node == null)
        return currentDepth

    currentDepth++

    return Math.max(maxDepth(node.right!!, currentDepth), maxDepth(node.left!!, currentDepth));
}

// ------- Code to generate our binary tree -------
class TreeNode(
    var value: Int? = null,
    var left: TreeNode? = null,
    var right: TreeNode? = null,
) {
    fun insert(values: Array<Int?>): TreeNode {
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(this)
        var i = 0
        while (queue.size > 0) {
            val current = queue.remove()
            if (current.left == null) {
                if (values[i] != null) {
                    current.left = TreeNode(value = values[i]);
                }
                i++
                if (i >= values.size)
                    return this
            }
            if (current.left != null)
                queue.add(current.left)

            if (current.right == null) {
                if (values[i] != null) {
                    current.right = TreeNode(value = values[i]);
                }
                i++
                if (i >= values.size)
                    return this
            }
            if (current.right != null)
                queue.add(current.right)
        }

        return this
    }

    fun insert2(value: Int): TreeNode {
        if (this.value == null)
            this.value = value
        else {
            val newNode = TreeNode(value)
            var currentNode = this
            while (true) {
                if (value < currentNode.value ?: 0) {
                    //Left
                    if (currentNode.left == null) {
                        currentNode.left = newNode
                        return this
                    }

                    currentNode = currentNode.left!!
                } else {
                    //Right
                    if (currentNode.right == null) {
                        currentNode.right = newNode
                        return this
                    }

                    currentNode = currentNode.right!!
                }
            }
        }
        return this
    }
}

//tree.insert(9)
//tree.insert(4)
//tree.insert(6)
//tree.insert(20)
//tree.insert(170)
//tree.insert(15)
//tree.insert(1)
//tree.remove(170)
//JSON.stringify(traverse(tree.root))
//
////     9
////  4     20
////1  6  15  170
//
fun traverse(node: TreeNode): TreeNode? {
    val tree = TreeNode(value = node.value)
    tree.left = if (node.left == null) null else traverse(node.left!!)
    tree.right = if (node.right == null) null else traverse(node.right!!)
    println(tree.value)
    return tree
}



