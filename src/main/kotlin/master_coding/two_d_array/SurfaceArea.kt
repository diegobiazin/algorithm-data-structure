package master_coding.two_d_array

//3D Surface Area
fun main() {
    val stack = arrayOf(
        arrayOf(1, 1),
//        arrayOf(2, 2, 3),
//        arrayOf(1, 2, 4)
    )
    val surfaceArea = surfaceArea(stack)
    println(surfaceArea)
}

fun surfaceArea(A: Array<Array<Int>>): Int {
    if (A.isEmpty())
        return 0

    var area = 0

    for (row in A.indices) {
        for (col in A[0].indices) {
            area += (A[row][col] * 4) + 2
            if (col >= 1) area -= Math.min(A[row][col - 1], A[row][col]) * 2
            if (row >= 1) area -= Math.min(A[row - 1][col], A[row][col]) * 2
        }
    }

    return area
}
//
//fun calculateSurfaceArea(grid: Array<Array<Int>>, currentRow: Int, currentCol: Int): Int {
//    if (currentRow < 0 || currentRow >= grid.size || currentCol < 0 || currentCol >= grid[0].size)
//        return 0
//
//    if (grid[currentRow][currentCol] == 1)
//        return 6
//
//    val directions = arrayOf(
//        arrayOf(-1, 0), //up
//        arrayOf(0, 1), //right
//        arrayOf(1, 0), //down
//        arrayOf(0, -1) //left
//    )
//
//    for (i in directions.indices) {
//        val currentDir = directions[i]
//        val row = currentDir[0]
//        val col = currentDir[1]
//        dfs(grid, currentRow + row, currentCol + col);
//    }
//}