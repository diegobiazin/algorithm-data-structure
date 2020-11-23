class RepeatString

fun main(args: Array<String>) {
    val result = repeatedString("x", 970770)
    print(result)
}

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {
    if (s.toCharArray().size == 1)
        return if (s == "a") n else 0

    if (n == 0L)
        return 0

    val length = s.length
    var result = s.toCharArray().filter { it == 'a' }.size.toLong()
    val factor = n / length
    val diff = n % s.length
    result *= factor
    for (i in 1..diff)
        if (s.toCharArray()[(i-1).toInt()] == 'a')
            result++


    return result
}
