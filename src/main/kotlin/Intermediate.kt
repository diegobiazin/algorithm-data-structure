fun main() {
//    val result = maxPairs(
//        arrayOf(
//            709552565,
//            473251358,
//            803612259,
//            579542802,
//            183012194,
//            689345248,
//            151290765,
//            123232501,
//            994391793,
//            25107191,
//            862726097
//        ), 440987423
//    )
//    println(result)
    val maxElement = maxElement(3, 7, 1)
    println(maxElement)
}

//fun maxPairs(skillLevel: Array<Int>, minDiff: Int): Int {
//    println("${skillLevel.map { it }} $minDiff")
//    if (skillLevel.size <= 1)
//        return 0
//
//    val sortedArray = skillLevel.sortedArray()
//    var result = 0
//    val numsMap = mutableMapOf<Int, Int>()
//    for (i in sortedArray.indices) {
//        val currentMapVal = numsMap[sortedArray[i]]
//
//        if (currentMapVal != null && currentMapVal >= 0) {
//            numsMap[sortedArray[i]] = numsMap[sortedArray[i]]!! - 1
//            result++
//        } else {
//            val numberToFind = sortedArray[i] - minDiff
//            val numberToFind2 = sortedArray[i] + minDiff
//            numsMap[numberToFind] = numsMap.getOrDefault(numberToFind, 0) + 1
//            numsMap[numberToFind2] = numsMap.getOrDefault(numberToFind2, 0) + 1
//        }
//    }
//    return result
//}

fun maxElement(n: Int, maxSum: Int, k: Int): Int {
    var count = maxSum
    val array = IntArray(maxSum)
    array[k] = n

    count -= k
    while (count > 0) {
        count -= Math.ceil((count / 2).toDouble()).toInt()
        if (array[k] == n)
            array[k] = count
        else
            array[k] = count
    }

    return array.size
}