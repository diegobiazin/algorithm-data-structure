package master_coding.two_d_array

import java.util.*

//Rotting Oranges - Solution

fun main() {
    val testMatrix = arrayOf(
        arrayOf(2, 1, 1, 0, 0),
        arrayOf(1, 1, 1, 0, 0),
        arrayOf(0, 1, 1, 1, 1),
        arrayOf(0, 1, 0, 0, 2)
    )
    val minutes = orangesRotting(testMatrix)
    println(minutes)
}

fun orangesRotting(matrix: Array<Array<Int>>): Int {
    if (matrix.isEmpty())
        return 0

    val ROTTEN = 2
    val FRESH = 1
    val EMPTY = 0

    val queue: Queue<Array<Int>> = LinkedList<Array<Int>>()
    var freshOranges = 0

    for (row in matrix.indices) {
        for (col in matrix[0].indices) {
            if (matrix[row][col] == ROTTEN) {
                queue.add(arrayOf(row, col))
            }

            if (matrix[row][col] == FRESH) {
                freshOranges++
            }
        }
    }

    var minutes = 0
    var currentQueueSize = queue.size

    while (queue.size > 0) {
        if (currentQueueSize == 0) {
            currentQueueSize = queue.size
            minutes++
        }

        val currentOrange = queue.remove()
        currentQueueSize--
        val row = currentOrange[0]
        val col = currentOrange[1]

        val directions = arrayOf(
            arrayOf(-1, 0), //up
            arrayOf(0, 1), //right
            arrayOf(1, 0), //down
            arrayOf(0, -1) //left
        )

        for (i in directions.indices) {
            val currentDir = directions[i]
            val nextRow = row + currentDir[0]
            val nextCol = col + currentDir[1]

            if (nextRow < 0 || nextRow >= matrix.size || nextCol < 0 || nextCol >= matrix[0].size)
                continue


            if (matrix[nextRow][nextCol] == FRESH) {
                matrix[nextRow][nextCol] = 2
                freshOranges--
                queue.add(arrayOf(nextRow, nextCol))
            }
        }
    }

    if (freshOranges != 0)
        return -1


    return minutes
}