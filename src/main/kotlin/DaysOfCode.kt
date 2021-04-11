import kotlin.math.max

fun main() {
//    decimalTOBinary(6)
    hourGlassSum()
}

fun hourGlassSum() {
    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })
    for (i in 0 .. 2) {
        arr[i]+arr[i+1]+arr[i+3]
    }
}

fun decimalTOBinary(number: Int) {
    var maxOne = 0
    var count = 0
    var result = number
    while (result > 0) {
        if (result % 2 > 0)
            count++
        else {
            maxOne = max(maxOne, count)
            count = 0
        }
        result /= 2
        maxOne = max(maxOne, count)
    }
    print(maxOne)
}