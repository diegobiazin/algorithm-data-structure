package master_coding.sort

import master_coding.recursion.quickSort

fun maximumToys(prices: Array<Int>, k: Int): Int {
    quickSort(prices, 0, prices.size - 1)
    var buget = k
    var result = 0
    for (i in prices.indices) {
        if (buget - prices[i] > 0) {
            result++
            buget -= prices[i]
        } else
            break
    }
    return result
}

fun main(args: Array<String>) {
    val k = 50
    val prices = arrayOf(1, 12, 5, 111, 200, 1000, 10)
    val result = maximumToys(prices, k)
    println(result)
}