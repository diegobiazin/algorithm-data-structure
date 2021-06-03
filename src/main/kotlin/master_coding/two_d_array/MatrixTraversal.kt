package master_coding.two_d_array

import java.util.*
import kotlin.collections.ArrayList

//Intro To 2D-Arrays - Basics & Traversal Algorithms
fun main() {
    val testMatrix = arrayOf(
        arrayOf(1, 2, 3, 4, 5),
        arrayOf(6, 7, 8, 9, 10),
        arrayOf(11, 12, 13, 14, 15),
        arrayOf(16, 17, 18, 19, 20)
    )

    traversalDFS(testMatrix)
    traversalBFS(testMatrix)
}


fun traversalDFS(matrix: Array<Array<Int>>): ArrayList<Int> {
    val seen = IntArray(matrix.size).map { Array(matrix[0].size) { false } }

    val values = ArrayList<Int>()

    dfs(matrix, 0, 0, seen, values);

    return values
}

fun dfs(matrix: Array<Array<Int>>, row: Int, col: Int, seen: List<Array<Boolean>>, values: ArrayList<Int>) {
    if (row < 0 || col < 0 || row >= matrix.size || col >= matrix[0].size || seen[row][col])
        return

    val directions = arrayOf(
        arrayOf(-1, 0), //up
        arrayOf(0, 1), //right
        arrayOf(1, 0), //down
        arrayOf(0, -1) //left
    )

    seen[row][col] = true;
    values.add(matrix[row][col])

    for (i in directions.indices) {
        val currentDir = directions[i]
        dfs(matrix, row + currentDir[0], col + currentDir[1], seen, values)
    }
}

fun traversalBFS(matrix: Array<Array<Int>>): ArrayList<Int> {
    val seen = IntArray(matrix.size).map { Array(matrix[0].size) { false } }

    val values = ArrayList<Int>()

    val queue: Queue<Array<Int>> = LinkedList()
    queue.add(arrayOf(0, 0))

    while (queue.isNotEmpty()) {
        val currentPos = queue.remove()
        val row = currentPos[0]
        val col = currentPos[1]

        if (row < 0 || row >= matrix.size || col < 0 || col >= matrix[0].size || seen[row][col])
            continue


        seen[row][col] = true
        values.add(matrix[row][col])

        val directions = arrayOf(
            arrayOf(-1, 0), //up
            arrayOf(0, 1), //right
            arrayOf(1, 0), //down
            arrayOf(0, -1) //left
        )

        for (i in directions.indices) {
            val currentDir = directions[i]
            queue.add(arrayOf(row + currentDir[0], col + currentDir[1]))
        }
    }

    return values
}