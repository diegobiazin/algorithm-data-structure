fun main() {
//    nonDivisibleSubset(3, arrayOf(1, 7, 2, 4))
//    nonDivisibleSubset(7, arrayOf(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436))
//    nonDivisibleSubset(4, arrayOf(19, 10, 12, 10, 24, 25, 22))
    nonDivisibleSubset(13, arrayOf(2375782, 21836421, 2139842193, 2138723, 23816, 21836219, 2948784, 43864923, 283648327, 23874673))
}

fun nonDivisibleSubset(k: Int, s: Array<Int>): Int {

    val remaining = mutableMapOf<Int, Int>()
    for (i in s) {
        if (remaining[i % k] == null)
            remaining[i % k] = 1
        else
            remaining[i % k] = remaining[i % k]!! + 1
    }

    if (k % 2 == 0)
        remaining[k / 2] = Math.min(remaining[k / 2]!!, 1)

    var result = Math.min(remaining[0] ?: 0, 1)

    for (i in 1..k / 2)
        result += Math.max(remaining[i] ?: 0, remaining[k - i] ?: 0)

    return result
}
