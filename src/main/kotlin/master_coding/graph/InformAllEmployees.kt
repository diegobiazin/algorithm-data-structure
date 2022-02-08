package master_coding.graph

//Time taken to inform employees - DFS solution
fun main() {
    val managersArray = arrayOf(2, 2, 4, 6, -1, 4, 4, 5)
    val informTimeArray = arrayOf(0, 0, 4, 0, 7, 3, 6, 0)
    val numOfMinutes = numOfMinutes(8, 4, managersArray, informTimeArray)
    println(numOfMinutes)
}


fun numOfMinutes(n: Int, headID: Int, managers: Array<Int>, informTime: Array<Int>): Int {
    val adjList = managers.map { ArrayList<Int>() }

    for (employee in 0 until n) {
        val manager = managers[employee]
        if (manager == -1)
            continue

        adjList[manager].add(employee)
    }

    return dfs(headID, adjList, informTime);
}

fun dfs(currentId: Int, adjList: List<ArrayList<Int>>, informTime: Array<Int>): Int {
    if (adjList[currentId].size == 0) {
        return 0
    }

    var max = 0
    val subordinates = adjList[currentId]
    for (i in subordinates.indices) {
        max = Math.max(max, dfs(subordinates[i], adjList, informTime))
    }

    return max + informTime[currentId]
}