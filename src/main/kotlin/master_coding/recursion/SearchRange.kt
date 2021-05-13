package master_coding.recursion

import kotlin.math.floor

fun main() {
    print(searchRange(arrayOf(1, 3, 3, 5, 5, 5, 8, 9), 5))
}

fun binarySearch(nums: Array<Int>, pleft: Int, pright: Int, target: Int): Int {
    var left = pleft
    var right = pright
    while (left <= right) {
        val mid = floor(((left + right) / 2).toDouble()).toInt()
        val foundVal = nums[mid]
        when {
            foundVal == target -> {
                return mid
            }
            foundVal < target -> {
                left = mid + 1
            }
            else -> {
                right = mid - 1
            }
        }
    }

    return -1
}

fun searchRange(nums: Array<Int>, target: Int) {
    if (nums.isEmpty())
        print("-1, -1")

    val firstPos = binarySearch(nums, 0, nums.size - 1, target);

    if (firstPos == -1)
        println("-1, -1")

    var endPos = firstPos
    var startPos = firstPos
    var temp1 = 0
    var temp2 = 0

    while (startPos != -1) {
        temp1 = startPos;
        startPos = binarySearch(nums, 0, startPos - 1, target);
    }
    startPos = temp1

    while (endPos != -1) {
        temp2 = endPos;
        endPos = binarySearch(nums, endPos + 1, nums.size - 1, target);
    }
    endPos = temp2;

    print("$startPos, $endPos")
}