package master_coding.two_d_array

// Walls and Gates - Solution
fun main() {
    val INF = 2147483647
    val testMatrix = arrayOf(
        arrayOf(INF, -1, 0, INF),
        arrayOf(INF, INF, INF, 0),
        arrayOf(INF, -1, INF, -1),
        arrayOf(0, -1, INF, INF)
    )
    wallsAndGates(testMatrix)
}

fun wallsAndGates(rooms: Array<Array<Int>>) {
    val WALL = -1
    val GATE = 0
    val EMPTY = 2147483647

    for (row in rooms.indices) {
        for (col in rooms[0].indices) {
            if (rooms[row][col] == GATE)
                dfs(rooms, row, col, 0)
        }
    }
};

fun dfs(grid: Array<Array<Int>>, row: Int, col: Int, count: Int) {
    if (row < 0 || row >= grid.size || col < 0 || col >= grid[0].size || count > grid[row][col])
        return

    grid[row][col] = count

    val directions = arrayOf(
        arrayOf(-1, 0), //up
        arrayOf(0, 1), //right
        arrayOf(1, 0), //down
        arrayOf(0, -1) //left
    )

    for (i in directions.indices) {
        val currentDir = directions[i]
        dfs(grid, row + currentDir[0], col + currentDir[1], count + 1)
    }
}