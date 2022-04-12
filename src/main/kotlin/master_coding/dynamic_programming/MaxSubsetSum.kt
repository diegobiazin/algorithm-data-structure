package master_coding.dynamic_programming

fun main() {
    maxSubsetSum(arrayOf(3, 7, 4, 6, 5))
    maxSubsetSum(arrayOf(-2, 1, 3, -4, 5))
}

fun maxSubsetSum(arr: Array<Int>): Int {
    val n = arr.size
    val dp = mutableMapOf<Int, Int>()
    val result = Math.max(maxSum(n - 1, arr, dp), maxSum(n - 2, arr, dp))
    print(result)
    return result
}

fun maxSum(i: Int, arr: Array<Int>, dp: MutableMap<Int, Int>): Int {
    if (i < 0) return 0

    if (dp[i] != null)
        return dp[i]!!

    val max = maxSum(i - 2, arr, dp)
    val maxValue = Math.max(arr[i] + max, max)
    dp[i] = Math.max(maxSum(i - 1, arr, dp), Math.max(maxValue, arr[i]))
    return dp[i]!!
}
