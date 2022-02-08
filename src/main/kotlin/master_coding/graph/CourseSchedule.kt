package master_coding.graph

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val adjacencyList = arrayOf(
        arrayOf(1, 0),
        arrayOf(2, 1),
        arrayOf(2, 5),
        arrayOf(0, 3),
        arrayOf(4, 3),
        arrayOf(3, 5),
        arrayOf(4, 5)
    )
    val canFinish = canFinish(6, adjacencyList)
    println(canFinish)
    println(canFinishOptimal(6, adjacencyList))
}

fun canFinish(n: Int, prerequisites: Array<Array<Int>>): Boolean {
    val adjList = Array<ArrayList<Int>>(n) { ArrayList<Int>() }

    for (i in prerequisites.indices) {
        val pair = prerequisites[i]
        adjList[pair[1]].add(pair[0])
    }

    val queue: Queue<Int> = LinkedList()
    for (v in 0 until n) {
        val seen = mutableMapOf<Int, Boolean>()
        for (i in adjList[v].indices) {
            queue.add(adjList[v][i])
        }

        while (queue.isNotEmpty()) {
            val current = queue.remove()
            seen[current] = true

            if (current == v)
                return false

            val adjacent = adjList[current]
            for (i in adjacent.indices) {
                val next = adjacent[i]
                if (!seen.getOrDefault(next, true)) {
                    queue.add(next)
                }
            }
        }
    }

    return true
}

fun canFinishOptimal(n: Int, prerequisites: Array<Array<Int>>): Boolean {
    val inDegree = Array<Int>(n) { 0 }

    for (i in prerequisites.indices) {
        inDegree[prerequisites[i][0]]++
    }

    val stack = Stack<Int>()

    for (i in inDegree.indices) {
        if (inDegree[i] == 0) {
            stack.push(i)
        }
    }

    var count = 0

    while (stack.isNotEmpty()) {
        val current = stack.pop()
        count++

        for (i in prerequisites.indices) {
            val pair = prerequisites[i]
            if (pair[1] == current) {
                inDegree[pair[0]]--
                if (inDegree[pair[0]] == 0) {
                    stack.push(pair[0])
                }
            }
        }
    }

    return count == n
}
