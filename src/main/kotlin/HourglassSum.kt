import kotlin.math.absoluteValue

class HourglassSum

fun main(args: Array<String>) {
//    0 -4 -6 0 -7 -6
//-1 -2 -6 -8 -3 -1
//-8 -4 -2 -8 -8 -6
//-3 -1 -2 -5 -7 -4
//-3 -5 -3 -6 -6 -6
//-3 -6 0 -8 -6 -7
    var scan = arrayOf("0 -4 -6 0 -7 -6", "-1 -2 -6 -8 -3 -1", "-8 -4 -2 -8 -8 -6",
            "-3 -1 -2 -5 -7 -4", "-3 -5 -3 -6 -6 -6", "-3 -6 0 -8 -6 -7")

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = scan[i].split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)
    val result1 = hourglassSumOptmized(arr)

    println(result)
    println(result1)
}

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
    var sum = mutableListOf<Int>()
    for (i in 0 until ((arr.size) - 3) + 1)
        for (j in 0 until ((arr.size) - 3) + 1)
            sum.add(arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);

    return sum.max()!!
}


fun hourglassSumOptmized(arr: Array<Array<Int>>): Int {
    var result = 0
    for (i in 0 .. 3)
        for (j in 0 .. 3) {
            val total = (arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2])
            if (total.absoluteValue > result)
                result = total
        }

    return result
}
