package master_coding.dynamic_programming

fun main() {
    println(candies(10, arrayOf(2, 4, 2, 6, 1, 7, 8, 9, 2, 1)))
}

fun candies(n: Int, arr: Array<Int>): Long {
    if (n == 1)
        return 1

    val candies = IntArray(n) { 1 }
    for (i in 1 until n) {
        if (arr[i] > arr[i - 1]) {
            candies[i] = candies[i - 1] + 1
        } else {
            candies[i] = 1
        }
    }

    for (i in n - 2 downTo 0) {
        if (arr[i] > arr[i + 1] && candies[i] <= candies[i + 1]) {
            candies[i] = candies[i + 1] + 1
        }
    }

    var sum: Long = 0
    for (c in candies) {
        sum += c.toLong()
    }
    return sum
}
//
//fun candiesRecursive(n: Int, arr: Array<Int>): Int {
//    if (n == 1)
//        return 1
//
//    val candies = IntArray(n) { 1 }
//
//    return Math.max(recursive(n - 1, n - 2, arr, candies), recursive(n - 2, n - 1, arr, candies))
//}
//
//fun recursive(i: Int, arr1: Int, arr: Array<Int>, candies: IntArray): Int {
//    if (arr[i] > arr[i - 1])
//        candies[i + 1] = candies[i] + 1
//
//    if (arr[i] < arr[i - 1])
//        candies[i - 1] = candies[i + 1] + 1
//
//    return Math.max(arr[i], arr[i - 1])
//}