package master_coding.dynamic_programming

import java.util.*

fun main() {
    val f = createF()
    val c = createC(f)

    println(decibinaryNumbers(f, c,1))
    println(decibinaryNumbers(f, c,2))
    println(decibinaryNumbers(f, c,3))
    println(decibinaryNumbers(f, c,4))
    println(decibinaryNumbers(f, c,10))
}

const val maxD = 19
const val maxS = 300000

fun pow2(n: Int) = 1 shl n

fun createF() = List(maxD + 1) { LongArray(maxS + 1) }.apply {
    this[0][0] = 1
    for (d in 1..maxD) {
        for (s in 0..maxS) {
            for (i in 0..9) {
                val previousS = s - i * pow2(d - 1)
                if (previousS >= 0) this[d][s] += this[d - 1][previousS]
            }
        }
    }
}

fun createC(f: List<LongArray>) = LongArray(maxS + 1).apply {
    this[0] = f[maxD][0]
    for (s in 1 until size) this[s] = this[s - 1] + f[maxD][s]
}

fun findS(c: LongArray, x: Long): Int {
    val s = c.binarySearch(x)
    return if (s >= 0) s else -s - 1
}

fun decibinaryNumbers(f: List<LongArray>, c: LongArray, x: Long): Long {
    var s = findS(c, x)
    var g = if (s > 0) x - c[s - 1] else x
    var decibinaryDigits = ""
    for (d in maxD downTo 1) {
        var i = 0
        var decibinaryCount = 0L
        var temp = 0L
        while (decibinaryCount < g) {
            temp = decibinaryCount
            decibinaryCount += f[d - 1][s - i++ * pow2(d - 1)]
        }
        i--
        decibinaryCount = temp
        decibinaryDigits += i
        s -= i * pow2(d - 1)
        g -= decibinaryCount
    }
    return decibinaryDigits.toLong()
}

