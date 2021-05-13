package master_coding.strings

fun alternatingCharacters(s: String): Int {
    var currentChar: Char = s[0]
    var result = 0
    for (i in 1 until s.toCharArray().size) {
        if (s[i] == currentChar) {
            result++
        } else {
            currentChar = s[i]
        }
    }

    return result
}

fun main(args: Array<String>) {
    val result = alternatingCharacters("AAABBB")
    println(result)
}