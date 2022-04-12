package master_coding.dynamic_programming

import kotlin.math.roundToInt

fun main() {
    val board = arrayOf(
        arrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        arrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        arrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        arrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        arrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        arrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        arrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        arrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        arrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )

    solveSudoku(board)

    println(board.map { it.map { v -> v } })
}

fun solveSudoku(board: Array<Array<Char>>) {
    val n = board.size
    val boxes = Array(n) { BooleanArray(n) { false } }
    val rows = Array(n) { BooleanArray(n) { false } }
    val cols = Array(n) { BooleanArray(n) { false } }


    for (r in 0 until n) {
        for (c in 0 until n) {
            if (board[r][c] != '.') {
                val boxId = getBoxId(r, c)
                val value = Character.getNumericValue(board[r][c]) - 1
                boxes[boxId][value] = true
                rows[r][value] = true
                cols[c][value] = true
            }
        }
    }

    solveBacktrack(board, boxes, rows, cols, 0, 0);
}

fun getBoxId(row: Int, col: Int): Int {
    val rowVal = Math.floor((row / 3).toDouble()) * 3
    val colVal = Math.floor((col / 3).toDouble())

    return (rowVal + colVal).roundToInt()
}

fun solveBacktrack(
    board: Array<Array<Char>>,
    boxes: Array<BooleanArray>,
    rows: Array<BooleanArray>,
    cols: Array<BooleanArray>,
    r: Int,
    c: Int
): Boolean {
    if (r == board.size || c == board[0].size) {
        return true
    } else {
        if (board[r][c] == '.') {
            for (num in 1..9) {
                val numVal = Character.forDigit(num, 16)
                board[r][c] = numVal

                val boxId = getBoxId(r, c)
                val box = boxes[boxId]
                val row = rows[r]
                val col = cols[c]

                if (isValid(box, row, col, num - 1)) {
                    box[num - 1] = true
                    row[num - 1] = true
                    col[num - 1] = true

                    if (c == board[0].size - 1) {
                        if (solveBacktrack(board, boxes, rows, cols, r + 1, 0)) {
                            return true
                        }
                    } else {
                        if (solveBacktrack(board, boxes, rows, cols, r, c + 1)) {
                            return true
                        }
                    }

                    box[num - 1] = false
                    row[num - 1] = false
                    col[num - 1] = false
                }

                board[r][c] = '.'
            }
        } else {
            if (c == board[0].size - 1) {
                if (solveBacktrack(board, boxes, rows, cols, r + 1, 0)) {
                    return true
                }
            } else {
                if (solveBacktrack(board, boxes, rows, cols, r, c + 1)) {
                    return true
                }
            }
        }
    }

    return false
}

fun isValid(box: BooleanArray, row: BooleanArray, col: BooleanArray, num: Int): Boolean {
    return !(box[num] || row[num] || col[num])
}



