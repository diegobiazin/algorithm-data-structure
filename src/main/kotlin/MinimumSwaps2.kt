import kotlin.math.max

class MinimumSwaps2

fun main(args: Array<String>) {
    println(minimumSwaps(arrayOf(4, 3, 1, 2)))
}

fun minimumSwaps(arr: Array<Int>): Int {
    var swaps = 0
    val correctOrder = arr.sortedArray()

    for(i in arr.indices) {
        val correctValue = correctOrder[i]
        if (arr[i] != (correctValue)) {
            val wrongIndex = arr.indexOf(correctValue)
            val temp = arr[i]
            arr[i] = correctValue
            arr[wrongIndex] = temp

            swaps++
        }
    }

    return swaps
}