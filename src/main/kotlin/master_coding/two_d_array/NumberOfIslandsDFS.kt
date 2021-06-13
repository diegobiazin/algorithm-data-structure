package master_coding.two_d_array

fun main() {
    val testMatrix = arrayOf(
        arrayOf(1, 1, 1, 0, 0),
        arrayOf(1, 1, 1, 0, 1),
        arrayOf(0, 1, 0, 0, 1),
        arrayOf(0, 0, 0, 1, 1)
    )
    val numberOfIslands = numberOfIslandsDfs(testMatrix)
    println(numberOfIslands)
}

fun numberOfIslandsDfs(grid: Array<Array<Int>>): Int {
    if (grid.isEmpty())
        return 0

    var islandCount = 0

    for (row in grid.indices) {
        for (col in grid[0].indices) {
            if (grid[row][col] == 1) {
                islandCount++
                dfs(grid, row, col)
            }
        }
    }

    return islandCount
}

fun dfs(grid: Array<Array<Int>>, currentRow: Int, currentCol: Int) {
    if (currentRow < 0 || currentRow >= grid.size || currentCol < 0 || currentCol >= grid[0].size)
        return

    if (grid[currentRow][currentCol] == 1) {
        grid[currentRow][currentCol] = 0;

        val directions = arrayOf(
            arrayOf(-1, 0), //up
            arrayOf(0, 1), //right
            arrayOf(1, 0), //down
            arrayOf(0, -1) //left
        )

        for (i in directions.indices) {
            val currentDir = directions[i]
            val row = currentDir[0]
            val col = currentDir[1]
            dfs(grid, currentRow + row, currentCol + col);
        }
    }
}
