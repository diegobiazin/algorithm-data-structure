package master_coding.strings


fun substrCount(n: Int, s: String): Long {
    var counter: Long = s.length.toLong()
    for (i in s.indices) {
        for (j in i + 1 until s.length) {
            if (s[i] == s[j]) {
                counter++
            } else {
                if (2 * j - i < s.length && s.substring(i, j).equals(s.substring(j + 1, 2 * j - i + 1))) {
                    counter++
                    break
                } else {
                    break
                }
            }
        }
    }

    return counter
}

fun main(args: Array<String>) {
    val result = substrCount(7, "aabaa")

    println(result)
}
