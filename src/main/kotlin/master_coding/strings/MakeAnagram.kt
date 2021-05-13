package master_coding.strings

import java.util.*
import kotlin.math.abs


fun makeAnagram(a: String, b: String): Int {
    val freq = IntArray(26)
    a.toCharArray().forEach { c -> freq[c - 'a']++ }
    b.toCharArray().forEach { c -> freq[c - 'a']-- }
    return freq.map { p -> Math.abs(p) }.sum()
}

fun main(args: Array<String>) {
    val res = makeAnagram("cde", "dcf")

    println(res)
}
