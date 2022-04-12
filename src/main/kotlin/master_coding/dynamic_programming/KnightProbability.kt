package master_coding.dynamic_programming

fun main() {
    println(knightProbabilityTopDown(6, 2, 2, 2))
    println(knightProbability(6, 2, 2, 2))
}

var DIRECTIONS = arrayOf(
    arrayOf(-2, -1),
    arrayOf(-2, 1),
    arrayOf(-1, 2),
    arrayOf(1, 2),
    arrayOf(2, 1),
    arrayOf(2, -1),
    arrayOf(1, -2),
    arrayOf(-1, -2)
)

fun knightProbabilityTopDown(N: Int, K: Int, r: Int, c: Int): Double {
    if (r < 0 || c < 0 || r >= N || c >= N) {
        return 0.0
    }

    if (K == 0) {
        return 1.0
    }

    var res = 0.0

    for (dir in DIRECTIONS) {
        res += knightProbabilityTopDown(N, K - 1, r + dir[0], c + dir[1]) / 8
    }

    return res
}

fun knightProbability(N: Int, K: Int, r: Int, c: Int): Double {
    val dp = IntArray(K + 1).map { Array(N) { 0.0 }.map { arrayOfNulls<Double>(N) } }
    return knightProbabilityTopDownRecursive(N, K, r, c, dp)
}

fun knightProbabilityTopDownRecursive(N: Int, K: Int, r: Int, c: Int, dp: List<List<Array<Double?>>>): Double {
    if (r < 0 || c < 0 || r >= N || c >= N) {
        return 0.0
    }

    if (K == 0) {
        return 1.0
    }

    if (dp[K][r][c] != null)
        return dp[K][r][c]!!

    var res = 0.0
    for (dir in DIRECTIONS) {
        res += knightProbabilityTopDownRecursive(N, K - 1, r + dir[0], c + dir[1], dp) / 8;
    }

    dp[K][r][c] = res

    return dp[K][r][c]!!
}

//fun knightProbabilityBottomUp(N: Int, K: Int, r: Int, c: Int): Int {
//    if (r < 0 || c < 0 || r >= N || c >= N) {
//        return 0
//    }
//
//    if (K == 0) {
//        return 1
//    }
//
//    var res = 0
//
//    for (dir in DIRECTIONS) {
//        res += knightProbabilityTopDown(N, K - 1, r + dir[0], c + dir[1]) / 8
//    }
//
//    return res
//}