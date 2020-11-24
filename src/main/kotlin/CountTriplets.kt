class CountTriplets

fun main(args: Array<String>) {
    println(countTriplets(arrayOf(1, 3, 9, 9, 27, 81), 3))
}

fun countTriplets(arr: Array<Long>, r: Long): Long {

    var leftMap = HashMap<Long, Long>()
    var rightMap = HashMap<Long, Long>()

    for (i in arr) {
        rightMap[i] = rightMap.getOrDefault(i, 0L) + 1
    }

    var count = 0L
    for (j in arr.indices) {
        var midTerm = arr[j]
        var c1 = 0L
        var c3 = 0L
        val prev = arr[j] / r
        val next = arr[j] * r

        rightMap[midTerm] = rightMap.getOrDefault(midTerm, 0L) - 1

        if (midTerm % r == 0L && leftMap.containsKey(prev)) {
            c1 = leftMap[prev]!!
        }

        if (rightMap.containsKey(next))
            c3 = rightMap[next]!!

        count += c1 * c3

        leftMap[midTerm] = leftMap.getOrDefault(midTerm, 0L) + 1
    }

//    BYPASS Solution
//    for (i in arr.indices) {
//        for (j in i + 1 until arr.size) {
//            for (k in j + 1 until arr.size) {
//                var prev = arr[j] / 3
//                var next = arr[j] * 3
//                if ((arr[i] == prev) && (arr[k] == next))
//                    count++
//            }
//        }
//    }

    return count
}
