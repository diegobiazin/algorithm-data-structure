package master_coding.sort

fun countSwaps(a: Array<Int>): Unit {
    val n = a.size
    var swaps = 0
    for (i in 0 until n) {
        for (j in 0 until n - i - 1) {
            if (a[j] > a[j + 1]) {
                swaps++
                val temp = a[j]
                a[j] = a[j + 1]
                a[j + 1] = temp
            }
        }
    }
    println("Array is sorted in $swaps swaps.")
    println("First Element: ${a[0]}")
    println("Last Element: ${a[a.size - 1]}")
}

fun main(args: Array<String>) {
    countSwaps(arrayOf(3, 2, 1))
}