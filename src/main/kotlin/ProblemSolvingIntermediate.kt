fun main() {
    println(maxPairs(arrayOf(3, 4, 5, 2, 1, 1), 3))
}

//fun numberOfWays(roads: Array<Array<Int>>): Int {
//    // Write your code here
//
//}

fun maxPairs(skillLevel: Array<Int>, minDiff: Int): Int {
    // Write your code here
    // Find the two index that the sum is equal the target
    println("${skillLevel.map { it }} $minDiff")
    val numsMap = mutableMapOf<Int, Int>()
    val pairNotFound = mutableListOf<Int>()
    var result = 0

    val sortedArrayDescending = skillLevel.sortedArrayDescending()
    for (p in sortedArrayDescending.indices) {
        val currentMapVal = numsMap.getOrDefault(sortedArrayDescending[p], 0)
        val found = numsMap.filter { it.key > sortedArrayDescending[p] && it.value > 0}
        val key = found.keys.indices.first
        if (currentMapVal > 0) {
            result++
            numsMap[currentMapVal] = numsMap.getOrDefault(currentMapVal, 0) - 1
        } else if (found.isNotEmpty() && numsMap.getOrDefault(key, 0) > 0){
            result++
        }
        else {
            val numberToFind = sortedArrayDescending[p] - minDiff
            numsMap[numberToFind] = numsMap.getOrDefault(numberToFind, 0) + 1
        }
    }



    return result
}