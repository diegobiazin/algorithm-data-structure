class ArrayManipulation

fun main(args: Array<String>) {
    println(arrayManipulation(10, arrayOf(
            arrayOf(2, 6, 8),
            arrayOf(3, 5, 7),
            arrayOf(1, 8, 1),
            arrayOf(5, 9, 15)
//            arrayOf(1, 2, 100),
//            arrayOf(2, 5, 100),
//            arrayOf(3, 4, 100)
    )))
}

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {

    var newArray = IntArray(n + 2) { 0 }
    for (i in queries.indices) {
        newArray[queries[i][0]] += queries[i][2]
        newArray[queries[i][1]+1] -= queries[i][2]
    }

    var sum = 0L
    var max = Long.MIN_VALUE
    for (j in newArray.indices) {
        sum += newArray[j]
        max = kotlin.math.max(max, sum)
    }

    return max
}