package master_coding.two_d_array

import java.util.*

fun main() {
    val testMatrix = arrayOf(
        arrayOf(1, 1, 1, 0, 0),
        arrayOf(1, 1, 1, 0, 1),
        arrayOf(0, 1, 0, 0, 1),
        arrayOf(0, 0, 0, 1, 1)
    )
    val numberOfIslands = numberOfIslands(testMatrix)
    println(numberOfIslands)
}


fun numberOfIslands(matrix: Array<Array<Int>>): Int {
    if (matrix.isEmpty())
        return 0

    var islandCount = 0

    for (row in matrix.indices) {
        for (col in matrix[0].indices) {
            if (matrix[row][col] == 1) {
                islandCount++
                matrix[row][col] = 0
                val queue: Queue<Array<Int>> = LinkedList<Array<Int>>()
                queue.add(arrayOf(row, col))

                while (queue.size > 0) {
                    val currentPos = queue.remove()
                    val currentRow = currentPos[0]
                    val currentCol = currentPos[1]

                    val directions = arrayOf(
                        arrayOf(-1, 0), //up
                        arrayOf(0, 1), //right
                        arrayOf(1, 0), //down
                        arrayOf(0, -1) //left
                    )

                    for (i in directions.indices) {
                        val currentDir = directions[i]
                        val nextRow = currentRow + currentDir[0]
                        val nextCol = currentCol + currentDir[1]

                        if (nextRow < 0 || nextRow >= matrix.size || nextCol < 0 || nextCol >= matrix[0].size)
                            continue

                        if (matrix[nextRow][nextCol] == 1) {
                            queue.add(arrayOf(nextRow, nextCol))
                            matrix[nextRow][nextCol] = 0
                        }
                    }
                }
            }
        }
    }

    return islandCount;
}
