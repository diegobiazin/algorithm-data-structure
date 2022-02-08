package master_coding.graph

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val times = arrayOf(
        arrayOf(1, 2, 9),
        arrayOf(1,4,2),
        arrayOf(2,5,1),
        arrayOf(4,2,4),
        arrayOf(4,5,6),
        arrayOf(3,2,3),
        arrayOf(5,3,7),
        arrayOf(3,1,5),
    )
    print(networkDelayTime(times, 5, 1))
}

fun networkDelayTime(times:Array<Array<Int>>, N: Int, k: Int): Int {
    val distances = Array<Double>(N) { Double.POSITIVE_INFINITY }
    val adjList = distances.map { ArrayList<ArrayList<Int>>() }
    distances[k - 1] = 0.0

    val heap = PriorityQueue<Int>{a, b -> a - b}
    heap.add(k - 1)

    for(i in times.indices) {
        val source = times[i][0]
        val target = times[i][1]
        val weight = times[i][2]
        adjList[source - 1].add(arrayListOf(target - 1, weight))
    }

    while(heap.isNotEmpty()) {
        val currentVertex = heap.remove()

        val adjacent = adjList[currentVertex];
        for(i in adjacent.indices) {
            val neighboringVertex = adjacent[i][0];
            val weight = adjacent[i][1];
            if(distances[currentVertex] + weight < distances[neighboringVertex]) {
                distances[neighboringVertex] = distances[currentVertex] + weight;
                heap.add(neighboringVertex);
            }
        }
    }

    val ans = distances.maxOrNull() ?: 0

    return if (ans == Double.POSITIVE_INFINITY) -1 else ans.toInt()
};