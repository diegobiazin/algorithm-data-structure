package master_coding.sort

import java.util.*

fun main(args: Array<String>) {
    println(activityNotifications(arrayOf(1, 2, 3, 4, 4), 4))
    println(activityNotifications(arrayOf(10, 20, 30, 40, 50), 3))
    println(activityNotifications(arrayOf(2, 3, 4, 2, 3, 6, 8, 4, 5), 5))
}

fun activityNotifications(expenditure: Array<Int>, d: Int): Int {
    val countingSort = IntArray(200)
    var pr = d

    for (i in 0 until pr)
        countingSort[expenditure[i]] += 1

    var current = 0
    var result = 0

    val medianPosition = if (d % 2 == 0) d / 2 else (d / 2) + 1
    val totalExpenditure = expenditure.size

    while (pr < totalExpenditure) {
        val median = getMedian(countingSort, d, medianPosition)
        if (expenditure[pr] >= 2 * median)
            result++

        countingSort[expenditure[current]]--
        countingSort[expenditure[pr]]++
        current++
        pr++
    }
    return result
}

fun getMedian(countingSort: IntArray, d: Int, medianPosition: Int): Double {
    var counter = 0
    var left = 0

    while (counter < medianPosition) {
        counter += countingSort[left]
        left++
    }

    var right = left
    left--

    if (counter > medianPosition || d % 2 != 0)
        return left.toDouble()
    else {
        while (countingSort[right] == 0) {
            right++
        }
        return (left + right).toDouble() / 2
    }
}
