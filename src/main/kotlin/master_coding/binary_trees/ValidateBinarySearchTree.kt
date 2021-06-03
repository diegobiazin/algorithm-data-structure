package master_coding.binary_trees

fun main() {
    /*
                10
            5       18
          3   8   12  25
     */
    val tree = TreeNode(10)
    tree.insert(arrayOf(5, 18, 3, 8, 12, 25))
    print(isValidBST(tree))
}

fun isValidBST(root: TreeNode): Boolean {
    if (root.value == null)
        return true

    return dfs(root, Double.NEGATIVE_INFINITY.toInt(), Double.POSITIVE_INFINITY.toInt())
}

fun dfs(node: TreeNode, min: Int, max: Int): Boolean {
    println("$min < ${node.value!!} < $max")
    if (node.value!! <= min || node.value!! >= max)
        return false


    if (node.left != null) {
        if (!dfs(node.left!!, min, node.value!!))
            return false

    }

    if (node.right != null) {
        if (!dfs(node.right!!, node.value!!, max))
            return false

    }

    return true
}

