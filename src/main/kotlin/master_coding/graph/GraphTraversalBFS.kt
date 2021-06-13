package master_coding.graph

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val adjacencyMatrix = arrayOf(
        arrayOf(0, 1, 0, 1, 0, 0, 0, 0, 0),
        arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 1, 0, 0, 0, 0, 1),
        arrayOf(1, 0, 1, 0, 1, 1, 0, 0, 0),
        arrayOf(0, 0, 0, 1, 0, 0, 1, 0, 0),
        arrayOf(0, 0, 0, 1, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 1, 0, 0, 1, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 1, 0, 0),
        arrayOf(0, 0, 1, 0, 0, 0, 0, 0, 0)
    )
    traversalMatrixBFS(adjacencyMatrix)

    val adjacencyList = arrayOf(
        arrayOf(1, 3),
        arrayOf(0),
        arrayOf(3, 8),
        arrayOf(0, 2, 4, 5),
        arrayOf(3, 6),
        arrayOf(3),
        arrayOf(4, 7),
        arrayOf(6),
        arrayOf(2)
    )
    traversalListBFS(adjacencyList)
}

fun traversalMatrixBFS(graph: Array<Array<Int>>): ArrayList<Int> {
    val seen = Array(graph.size) { false }
    val queue: Queue<Int> = LinkedList<Int>()
    queue.add(0)
    val values = ArrayList<Int>()

    while (queue.isNotEmpty()) {
        val vertex = queue.remove()

        values.add(vertex)
        seen[vertex] = true

        val connections = graph[vertex]
        for (v in connections.indices) {
            if (connections[v] > 0 && !seen[v]) {
                queue.add(v)
            }
        }
    }

    return values
}

fun traversalListBFS(graph: Array<Array<Int>>): ArrayList<Int> {
    val seen = Array(graph.size) { false }
    val queue: Queue<Int> = LinkedList<Int>()
    queue.add(0)
    val values = ArrayList<Int>()

    while (queue.isNotEmpty()) {
        val vertex = queue.remove()

        values.add(vertex)
        seen[vertex] = true

        val connections = graph[vertex]
        for (i in connections.indices) {
            val connection = connections[i]
            if (!seen[connection]) {
                queue.add(connection)
            }
        }
    }

    return values
}
