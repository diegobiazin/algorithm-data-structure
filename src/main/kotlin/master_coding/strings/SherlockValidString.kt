package master_coding.strings

import java.util.*


fun isValid(s: String): String {
    if (s.length <= 3)
        return "YES"

    val l = IntArray(26)
    s.toCharArray().forEach {
        l[it - 'a']++
    }

    Arrays.sort(l)
    var min = 0
    val max = l[25]
    while (l[min] == 0) {
        min++
    }

    if (l[min] == max)
        return "YES"

    if (((max - l[min] == 1) && (max > l[24])) || (l[min] == 1) && (l[min + 1] == max))
        return "YES"
    else
        return "NO"
}

fun main(args: Array<String>) {
    println(isValid("abc"))
    println(isValid("abcc"))
    println(isValid("aabbc"))
    println(isValid("abccc"))
    println(isValid("aabbcd"))
    println(isValid("abcdefghhgfedecba"))
}