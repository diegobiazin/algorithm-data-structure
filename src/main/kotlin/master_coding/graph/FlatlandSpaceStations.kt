package master_coding.graph

import java.util.*


fun main() {
    println(flatlandSpaceStations(5, arrayOf(0, 4)))
}

fun flatlandSpaceStations(n: Int, c: Array<Int>): Int {
    Arrays.sort(c)
    var maxDistance: Int = c[0]
    for (i in 1 until c.size) {
        val distance = (c[i] - c[i - 1]) / 2
        maxDistance = Math.max(distance, maxDistance)
    }
    val lastSpaceStationDistance = n - 1 - c[c.size - 1]
    maxDistance = Math.max(lastSpaceStationDistance, maxDistance)

    return maxDistance
}