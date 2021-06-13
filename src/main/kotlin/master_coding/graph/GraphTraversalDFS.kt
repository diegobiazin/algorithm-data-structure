package master_coding.graph

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
    val values = ArrayList<Int>()
    val seen = Array(adjacencyMatrix.size) { false }
    traversalMatrixDFS(0, adjacencyMatrix, values, seen)

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
    traversalListDFS(0, adjacencyMatrix, values, seen)
}

fun traversalMatrixDFS(vertex: Int, graph: Array<Array<Int>>, values: ArrayList<Int>, seen: Array<Boolean>) {
    values.add(vertex)
    seen[vertex] = true

    val connections = graph[vertex]
    for (v in connections.indices) {
        if (connections[v] > 0 && !seen[v]) {
            traversalMatrixDFS(v, graph, values, seen)
        }
    }
}

fun traversalListDFS(vertex: Int, graph: Array<Array<Int>>, values: ArrayList<Int>, seen: Array<Boolean>) {
    values.add(vertex)
    seen[vertex] = true

    val connections = graph[vertex]
    for (i in connections.indices) {
        val connection = connections[i]

        if (!seen[connection])
            traversalListDFS(connection, graph, values, seen);
    }
}