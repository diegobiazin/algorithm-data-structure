package master_coding.arrays

import kotlin.math.max
import kotlin.math.min

fun main() {
    maximumWaterContainer(arrayOf(4, 8, 1, 2, 3, 9))
    maximumWaterContainerOptimal(arrayOf(4, 8, 1, 2, 3, 9))
}

fun maximumWaterContainer(heights: Array<Int>) {
    var maxArea = 0
    for (p1 in heights.indices) {
        for (p2 in p1 + 1 until heights.size) {
            val height = min(heights[p1], heights[p2])
            val width = p2 - p1
            val area = height * width
            maxArea = max(maxArea, area)
        }
    };

    print(maxArea)
}

fun maximumWaterContainerOptimal(heights: Array<Int>) {
    var p1 = 0
    var p2 = heights.size - 1
    var maxArea = 0

    while (p1 < p2) {
        val height = min(heights[p1], heights[p2])
        val width = p2 - p1
        val area = height * width
        maxArea = max(maxArea, area)

        if (heights[p1] <= heights[p2]) {
            p1++
        } else {
            p2--
        }
    }

    print(maxArea)
}