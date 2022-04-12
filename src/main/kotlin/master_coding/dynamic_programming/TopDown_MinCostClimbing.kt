package master_coding.dynamic_programming

fun main() {
    print(minCostClimbingStairs(listOf(20, 15, 30, 5)))
    print(minCostClimbingStairsMemoization(listOf(20, 15, 30, 5)))
    print(minCostClimbingStairsBottomUp(listOf(20, 15, 30, 5)))
    print(minCostClimbingStairsBottomUpOptimized(listOf(20, 15, 30, 5)))
}

fun minCostClimbingStairs(cost: List<Int>): Int {
    val n = cost.size
    return Math.min(minCost(n - 1, cost), minCost(n - 2, cost))
}

fun minCost(i: Int, cost: List<Int>): Int {
    if (i < 0) return 0
    if (i == 0 || i == 1) return cost[i]
    return cost[i] + Math.min(minCost(i - 1, cost), minCost(i - 2, cost))
}

fun minCostClimbingStairsMemoization(cost: List<Int>): Int {
    val n = cost.size
    val dp = mutableMapOf<Int, Int>()
    return Math.min(minCostMemoization(n - 1, cost, dp), minCostMemoization(n - 2, cost, dp))
}

fun minCostMemoization(i: Int, cost: List<Int>, dp: MutableMap<Int, Int>): Int {
    if (i < 0) return 0
    if (i == 0 || i == 1) return cost[i]
    if (dp[i] != null)
        return dp[i]!!

    dp[i] = cost[i] + Math.min(minCostMemoization(i - 1, cost, dp), minCostMemoization(i - 2, cost, dp))
    return dp[i]!!
}

fun minCostClimbingStairsBottomUp(cost: List<Int>): Int {
    val n = cost.size
    if (n == 0) return 0
    if (n == 1) return cost[0]
    val dp = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        if (i < 2) {
            dp[i] = cost[i]
        } else {
            dp[i] = cost[i] + Math.min(dp[i - 1]!!, dp[i - 2]!!)
        }
    }

    return Math.min(dp[n - 1]!!, dp[n - 2]!!)
}

fun minCostClimbingStairsBottomUpOptimized(cost: List<Int>): Int {
    val n = cost.size
    if (n == 0) return 0
    if (n == 1) return cost[0]
    var dpOne = cost[0]
    var dpTwo = cost[1]
    for (i in 2 until n) {
        val current = cost[i] + Math.min(dpOne, dpTwo)
        dpOne = dpTwo
        dpTwo = current
    }

    return Math.min(dpOne, dpTwo)
}
