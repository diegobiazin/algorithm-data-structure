fun main() {
//    print(solution("55-5 000 00-00"))
    print(solution(4, intArrayOf(1, 2, 4, 4, 3), intArrayOf(2, 3, 1, 3, 1)))
}

fun solution(A: Array<String>, B: Array<String>, P: String): String {
    val result = mutableListOf<String>()
    for (i in B.indices) {
        if (B[i].contains(P))
            result.add(A[i])
    }

    if (result.isEmpty())
        return "NO CONTACT"

    result.sort()
    return result[0]
}

fun solution(S: String): String {
    var formatted = S.replace(" ", "").replace("-", "")
    var result = ""
    if (formatted.length % 3 == 0) {
        while (formatted.isNotEmpty()) {
            result += "${formatted[0]}${formatted[1]}${formatted[2]}-"
            formatted = formatted.removeRange(0, 3)
        }
        result = result.dropLast(1)
    } else {
        while (formatted.isNotEmpty()) {
            if (formatted.length == 2 || formatted.length == 4) {
                result += "${formatted[0]}${formatted[1]}-"
                formatted = formatted.removeRange(0, 2)
            } else {
                result += "${formatted[0]}${formatted[1]}${formatted[2]}-"
                formatted = formatted.removeRange(0, 3)
            }
        }
        result = result.dropLast(1)
    }

    return result
}


fun solution(N: Int, A: IntArray, B: IntArray): Boolean {
    val paths = HashMap<Int, Int>()
    for (i in A.indices)
        paths[A[i]] = B[i]

    var count = 0
    var nextConnection = 1
    for ((k, v) in paths) {
        if ((nextConnection == k && k == v - 1) || nextConnection == k - 1 && (v == k - 1 || v == k + 1)) {
            count++
            nextConnection = paths[k]!!
        }
    }

    return count == N - 1
}


