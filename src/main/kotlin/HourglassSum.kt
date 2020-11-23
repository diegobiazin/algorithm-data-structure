class HourglassSum

fun main(args: Array<String>) {

    var scan = arrayOf("1 1 1 0 0 0", "0 1 0 0 0 0", "1 1 1 0 0 0",
            "0 0 2 4 4 0", "0 0 0 2 0 0", "0 0 1 2 4 0")

    println(scan)
    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = scan[i].split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    println(arr)
    val result = hourglassSum(arr)

    println(result)
}

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
    var sum = mutableListOf<Int>()
    for (i in 0 until ((arr.size) - 3) + 1)
        for (j in 0 until ((arr.size) - 3) + 1)
            sum.add(arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);

    return sum.max()!!
}
